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
 * @author CHRISTIAN
 */
public class PlanificacionService {
     public List<Map<String, ?>> listarSecciones() {
        
        List<Map<String, ?>> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "SELECT s.IDSALON, s.AÑO, s.GRADO,"
                    + " n.DES_NIVEL from seccion s inner "
                    + "join nivel n on s.idnivel = n.idnivel";
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

    public void generarSeccion(int nivel, int salon, String año, String grado) {
        //---------------------------------------------------------------------
        Connection cn = null;
        try {
            // Inicio de la Tx
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String sql = "INSERT INTO SECCION VALUES(null,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, nivel);
            pstm.setInt(2, salon);

            pstm.setString(3, año);
            pstm.setString(4, grado);

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

    }
    
}
