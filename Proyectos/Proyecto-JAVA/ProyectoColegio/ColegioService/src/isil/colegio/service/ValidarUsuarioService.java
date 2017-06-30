/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import isil.colegio.db.AccesoDB;
import isil.colegio.util.JdbcUtil;
/**
 *
 * @author Usuario
 */
public class ValidarUsuarioService {
    
    public boolean autenticar(String user,String pass) {
   
    // ---------------------------------------
    // Proceso
    // ---------------------------------------
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
              
      String sql = "select usuario,clave from empleado ";
         
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery(sql);
     
      
      while(rs.next())
      {
          if (user.equals(rs.getString("USUARIO")) && pass.equals(rs.getString("CLAVE"))) {
              
              return true;
          }
      
      
      }
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error en el proceso consultar Usuarios.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    // ---------------------------------------
    return false;
  }   
    
    
        
       public List<Map<String, ?>> obtenerDatos(String usuario,String  clave) {
        List<Map<String, ?>> lista = null;
        // ---------------------------------------
        // Proceso
        // ---------------------------------------
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idper from empleado where usuario = ? and clave = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
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
