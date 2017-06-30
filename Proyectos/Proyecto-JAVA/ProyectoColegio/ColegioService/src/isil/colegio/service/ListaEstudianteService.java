/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.service;

import isil.colegio.db.AccesoDB;
import isil.colegio.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class ListaEstudianteService {
    
     public List<Map<String, ?>> listarEstudiantes() {
    List<Map<String, ?>> lista = null;
    // ---------------------------------------
    // Proceso
    // ---------------------------------------
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
              
      String sql = "select idest,nombre_est,apellido_est,apoderado,correo_apo from estudiante"; 
         
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException("Error en el proceso consultar Estudiantes.");
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
