package com.obeyz.bookstore.service;

import com.obeyz.bookstore.db.AccesoDB;
import com.obeyz.bookstore.model.Publicacion;
import com.obeyz.bookstore.model.Venta;
import com.obeyz.bookstore.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benjamin
 */
public class VentaService {

    public List < Map < String, ? >> ventasPorTipoPublicacion(String tipo) {
        List < Map < String, ? >> lista = null;
        // ---------------------------------------
        // Proceso
        // ---------------------------------------
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "SELECT\n" +
                "CONCAT(empleado.nombre,' ',\n" +
                "empleado.apellido) as empleado,\n" +
                "venta.idventa,\n" +
                "venta.cliente,\n" +
                "venta.fecha,\n" +
                "publicacion.titulo,\n" +
                "venta.precio,\n" +
                "venta.dcto,\n" +
                "venta.cantidad,\n" +
                "venta.total\n" +
                "FROM\n" +
                "venta\n" +
                "INNER JOIN publicacion ON venta.idpublicacion = publicacion.idpublicacion\n" +
                "INNER JOIN empleado ON venta.idempleado = empleado.idempleado" +
                " INNER JOIN tipo ON publicacion.idtipo = tipo.idtipo" +
                " WHERE tipo.idtipo=?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, tipo);
            ResultSet rs = pstm.executeQuery();
            lista = JdbcUtil.rsToList(rs);
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso consultar saldo.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {}
        }
        // ---------------------------------------
        return lista;
    }
    
    public String registrarNuevaPublicacion(Publicacion publicacion){
        Connection cn = null;
        ///////////////////////////
        Integer idpublicacion = 0;
        String strIdpublicacion = "";
        
        try {
            // Inicio de la Tx
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            // Datos de la cuenta
            String sql = "SELECT\n" +
                "idpublicacion\n" +
                "FROM\n" +
                "publicacion\n" +
                "WHERE idtipo=?\n" +
                "ORDER BY\n" +
                "publicacion.idpublicacion DESC\n" +
                "LIMIT 1";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, publicacion.getIdtipo());
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Tipo no existe.");
            }
            Map < String, ? > publicacionData = JdbcUtil.rowToMap(rs);
            rs.close();
            pstm.close();
            idpublicacion = Integer.parseInt(publicacionData.get("IDPUBLICACION").toString().substring(3));
            // Actualizar cuenta
            idpublicacion++;
            strIdpublicacion = publicacion.getIdtipo()+ String.format("%05d", idpublicacion);
            // Registrar movimiento
            sql = "insert into publicacion("
                    + "idpublicacion,"
                    + "titulo,"
                    + "autor,"
                    + "nroedicion,"
                    + "precio,"
                    + "stock,"
                    + "idtipo) "
                    + "VALUES(?,?,?,?,?,?,?)";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, strIdpublicacion );
            pstm.setString(2, publicacion.getTitulo());
            pstm.setString(3, publicacion.getAutor());
            pstm.setInt(4, publicacion.getNroedicion());
            pstm.setDouble(5, publicacion.getPrecio());
            pstm.setInt(6, publicacion.getStock());
            pstm.setString(7, publicacion.getIdtipo());
            pstm.executeUpdate();
            pstm.close();
            // Confirmar Tx
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {}
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {}
            throw new RuntimeException("Error en el proceso.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {}
        }     
        return strIdpublicacion;
    }
    
    public Integer efectuarVenta(Venta venta){
        double descuento = 0.0; 
        int numVenta = 0;
        int stock = 0;
        double precio = 0.0;
        //---------------------------------------------------------------------
        Connection cn = null;
        try {
            // Inicio de la Tx
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            
            // Datos de la promocion
            String sql = "select porcentaje from promocion "
                    + "where ? >= cantmin AND ? <= cantmax";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, venta.getCantidad());
            pstm.setInt(2, venta.getCantidad());
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("No se puede puede efectuar la venta.");
            }
            Map < String, ? > descuentoData = JdbcUtil.rowToMap(rs);
            rs.close();
            pstm.close();
            descuento = Double.parseDouble(descuentoData.get("PORCENTAJE").toString());
            
            // Obtener numero venta
            sql = "select valor from control where parametro ='venta'";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Cuenta no existe.");
            }
            Map < String, ? > ventaData = JdbcUtil.rowToMap(rs);
            rs.close();
            pstm.close();
            numVenta = Integer.parseInt(ventaData.get("VALOR").toString());
            
            //Actualizar numero venta
            numVenta+=1;
            sql = "update control set valor=? where parametro='venta'";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, numVenta);
            int filas = pstm.executeUpdate();
            if (filas != 1) {
                throw new SQLException("Error, no se puede actualizar el control.");
            }
            pstm.close();
            
            //Obtener stock y precio
            sql = "select stock, precio from publicacion where idpublicacion=?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, venta.getIdpublicacion());
            rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Publicacion no existe.");
            }
            Map < String, ? > stockData = JdbcUtil.rowToMap(rs);
            rs.close();
            pstm.close();
            stock = Integer.parseInt(stockData.get("STOCK").toString());
            precio = Double.parseDouble(stockData.get("PRECIO").toString());
            
            //Actualizar stock publicacion
            sql = "update publicacion set stock=? where idpublicacion=?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, stock-venta.getCantidad());
            pstm.setString(2, venta.getIdpublicacion());
            filas = pstm.executeUpdate();
            if (filas != 1) {
                throw new SQLException("Error, no se puede actualizar la publicacion.");
            }
            pstm.close();            
            
            // Registrar venta
            sql = "insert into venta("+
                "idventa,"+
                "cliente,"+
                "fecha,"+
                "idempleado,"+
                "idpublicacion,"+
                "cantidad,"+
                "precio,"+
                "dcto,"+
                "subtotal,"+
                "impuesto,"+
                "total) " +
                "VALUES(?,?,SYSDATE(),?,?,?,?,?,?,?,?)";   
            
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, numVenta);
            pstm.setString(2, venta.getCliente());
            pstm.setInt(3, venta.getIdempleado());
            pstm.setString(4, venta.getIdpublicacion());
            pstm.setInt(5, venta.getCantidad());
            pstm.setDouble(6, precio);
            double dcto = precio*descuento;
            pstm.setDouble(7, dcto);
            double total = (precio-dcto) * venta.getCantidad();
            double subtotal = total/1.19;
            double impuesto = total-subtotal;
            pstm.setDouble(8, subtotal);
            pstm.setDouble(9, impuesto);
            pstm.setDouble(10, total );
            pstm.executeUpdate();
            pstm.close();
            // Confirmar Tx
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {}
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {}
            throw new RuntimeException("Error en el proceso.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {}
        }
        //---------------------------------------------------------------------
        return numVenta;
    }
    
}