package Service;

import DB.AccesoDB;
import Model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author HP de Franchesco
 */

public class LogeoService {
    
    public Empleado validar(String usuario, String clave) {
    Empleado empleado = null;
    Connection cnx = null;
    try 
    {
      cnx = AccesoDB.getConnection();
      // Inicio de Sesion
      String sql = "select idemp from usuario where usuario=? and clave=? and estado=1";
      PreparedStatement pstm = cnx.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) 
      {
        throw new Exception("Usuario o Clave Incorrectos.");
      }
      int idemp = rs.getInt("idemp");//Se Captura el ID del Empleado
      rs.close();
      pstm.close();
      
      // Datos del empleado
      sql = "select idemp, nombre, apellido, dni,direccion, telefono, correo, estado from empleado where idemp = ? and estado = 1";
      pstm = cnx.prepareStatement(sql);
      pstm.setInt(1, idemp);
      rs = pstm.executeQuery();
      if (!rs.next()) 
      {
        throw new Exception("Usted no esta Autorizado");
      }
      empleado = new Empleado();
      empleado.setIdemp(rs.getInt("idemp"));
      empleado.setNombre(rs.getString("nombre"));
      empleado.setApellido(rs.getString("apellido"));
      empleado.setDni(rs.getString("dni"));
      empleado.setDireccion(rs.getString("direccion"));
      empleado.setTelefono(rs.getString("telefono"));
      empleado.setCorreo(rs.getString("correo"));
      empleado.setEstado(rs.getInt("estado"));
      rs.close();
      pstm.close();
    } 
    catch (Exception e) 
    {
      throw new RuntimeException(e.getMessage());
    } 
    finally 
    {
      try 
      {
        cnx.close();
      } 
      catch (Exception e) 
      {
      }
    }
    return empleado;
  }  
}
