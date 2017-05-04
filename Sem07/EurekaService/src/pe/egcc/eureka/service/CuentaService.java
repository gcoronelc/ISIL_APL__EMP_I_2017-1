package pe.egcc.eureka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import pe.egcc.eureka.db.AccesoDB;
import pe.egcc.eureka.util.JdbcUtil;

public class CuentaService {

  public double conSaldoCuenta(String cuenta) {
    double saldo = 0.0;
    // ---------------------------------------
    // Proceso
    // ---------------------------------------
    // Variables
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select dec_cuensaldo from cuenta where chr_cuencodigo=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new SQLException("Cuenta no existe.");
      }
      saldo = rs.getDouble("dec_cuensaldo");
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
    return saldo;
  }

  public List<Map<String, ?>> conMovimientos(String cuenta) {
    List<Map<String, ?>> lista = null;
    // ---------------------------------------
    // Proceso
    // ---------------------------------------
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select CUENCODIGO, MONENOMBRE, "
              + "CUENSALDO, CUENESTADO, MOVINUMERO, "
              + "MOVIFECHA, MOVIIMPORTE, TIPOCODIGO, "
              + "TIPONOMBRE  from v_movimiento "
              + "where CUENCODIGO = ? "
              + "order by movinumero ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
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

  public int procDeposito(String cuenta, double importe, String codEmp) {
    int nroMov = 0;
    //---------------------------------------------------------------------
    Connection cn = null;    
    try {
      // Inicio de la Tx
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      // Datos de la cuenta
      String sql = "select dec_cuensaldo, int_cuencontmov "
              + "from cuenta where vch_cuenestado = 'ACTIVO' "
              + "and chr_cuencodigo = ? "
              + "FOR UPDATE ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new SQLException("Cuenta no existe.");
      }
      Map<String,?> cuentaData = JdbcUtil.rowToMap(rs);
      rs.close();
      pstm.close();
      nroMov = Integer.parseInt(cuentaData.get("INT_CUENCONTMOV").toString());
      double saldo = Double.parseDouble(cuentaData.get("DEC_CUENSALDO").toString());
      // Error para probar FOR UPDATE
      // Thread.currentThread().sleep(2000);
      // Actualizar cuenta
      nroMov++;
      saldo += importe;
      sql = "update cuenta set dec_cuensaldo=?, int_cuencontmov=? "
              + "where chr_cuencodigo = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setInt(2, nroMov);
      pstm.setString(3, cuenta);
      int filas = pstm.executeUpdate();
      if(filas != 1){
        throw new SQLException("Error, no se puede actualizar la cuenta.");
      }
      pstm.close();
      // Registrar movimiento
      sql = "insert into movimiento(chr_cuencodigo,int_movinumero,"
              + "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
              + "dec_moviimporte) values(?,?,SYSDATE(),?,'003',?)";
      
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, nroMov);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (SQLException e) {
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
    //---------------------------------------------------------------------
    return nroMov;
  }
}
