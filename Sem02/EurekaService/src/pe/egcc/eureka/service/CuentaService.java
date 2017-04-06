
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

  public double conSaldoCuenta(String cuenta){
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
      if(!rs.next()){
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
  
  public List<Map<String,?>> conMovimientos(String cuenta){
    List<Map<String,?>> lista = null;
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
  
  
  
}
