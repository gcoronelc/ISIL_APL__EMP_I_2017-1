/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.service;

import isil.colegio.db.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class RegistroService {
    
     public void registrarEmpleado(String usuario, String clave,
            String nombre, String apellido, String correo,int idper){
    
    //---------------------------------------------------------------------
    Connection cn = null;    
    try {
      // Inicio de la Tx
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      String  sql = "INSERT INTO EMPLEADO(USUARIO,CLAVE,NOMBRE_EMP,APELLIDO_EMP,CORREO,IDPER) VALUES(?,?,?,?,?,?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      
      pstm.setString(3, nombre);
      pstm.setString(4, apellido);
      pstm.setString(5, correo);
       pstm.setInt(6, idper);
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
     
     
      public void registrarEstudiante( String NOMBRE_EST,
            String APELLIDO_EST, String APODERADO, String CORREO_APO){
    
    //---------------------------------------------------------------------
    Connection cn = null;    
    try {
      // Inicio de la Tx
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      String  sql = "INSERT INTO ESTUDIANTE(NOMBRE_EST,APELLIDO_EST,APODERADO,CORREO_APO) VALUES(?,?,?,?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, NOMBRE_EST);
      pstm.setString(2, APELLIDO_EST);
      
      pstm.setString(3, APODERADO);
      pstm.setString(4, CORREO_APO);
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
    
}
