/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.service;

import isil.colegio.db.AccesoDB;
import isil.colegio.util.JdbcUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CHRISTIAN
 */
public class VentaService {

    public List<Map<String, ?>> PagosPorEstudiante(String idAlumno) {
        List<Map<String, ?>> lista = null;
        // ---------------------------------------
        // Proceso
        // ---------------------------------------
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select E.NOMBRE_EST , E.APELLIDO_EST ,"
                    + " E.APODERADO , E.CORREO_APO, P.MONTO ,"
                    + " P.MORA, P.FEC_PAGO, P.FEC_VENCIM"
                    + " from pago p inner join estudiante e on p.IDEST = e.IDEST where E.IDEST = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, idAlumno);
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
            } catch (Exception e) {
            }
        }
        // ---------------------------------------
        return lista;
    }
    
    public void registrarPago(int tipo, double monto,
            String fec_pago, String fec_venc, int est, int mat){
    
    //---------------------------------------------------------------------
    Connection cn = null;    
    try {
      // Inicio de la Tx
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      String  sql = "INSERT INTO PAGO VALUES(null,?,?,0,?,?,?,?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, tipo);
      pstm.setDouble(2, monto);
      
      pstm.setString(3, fec_pago);
      pstm.setString(4, fec_venc);
      pstm.setInt(5, est);
      pstm.setInt(6, mat);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    }catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error en el proceso.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    
    }
    
    public int regIngreso(int idest) {
    int idmat ;
    Connection cn = null;
    try {
      // El objeto Connection
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Verificar que matricula no exista
      String sql = "select count(*) cont from matricula "
              + "where idest=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1,idest );

      ResultSet rs = pstm.executeQuery();
      rs.next();
      int cont = rs.getInt("cont");
      rs.close();
      pstm.close();
      if (cont > 0) {
        throw new Exception("Estudiante ya esta matriculado.");
      }
      // Registrar matricula
      sql = "insert into matricula values(null,?,sysdate())";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idest);
      
      pstm.executeUpdate();
      pstm.close();
      // Leer el id de matricula
      sql = "select last_insert_id() idmat";
      pstm = cn.prepareStatement(sql);
      rs = pstm.executeQuery();
      rs.next();
      idmat = rs.getInt("idmat");
      rs.close();
      pstm.close();
      // Registrar Pago
      sql = "insert into pago values(null,2,700,0,sysdate(),'2017-03-01',?,?)";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idest);
      pstm.setInt(2, idmat);
      
      pstm.executeUpdate();
      pstm.close();
      // Confirmar transacciòn
      cn.commit();
      // Fin
     // bean.setIdmat(idmat);
    } catch (Exception e) {
      try {
        // Cancela la Transacción
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return idmat;
    
}
    
     public List<Map<String, ?>> getEstudiantesIngreso() {
    List<Map<String, ?>> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idest, concat(APELLIDO_EST,', ',NOMBRE_EST) nombre "
              + "from estudiante "
              + "where idest not in ( "
              + "select distinct idest from matricula)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
}
    
    
    

}
