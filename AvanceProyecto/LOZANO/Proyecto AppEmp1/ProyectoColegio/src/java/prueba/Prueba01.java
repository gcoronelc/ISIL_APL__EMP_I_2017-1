package prueba;
/**
 *
 * @author HP de Franchesco
 */
import java.sql.Connection;
import DB.AccesoDB;
import Model.Empleado;
import Service.LogeoService;

public class Prueba01 {
  
  public static void main(String[] args) {
    try 
    {
      Connection cn = AccesoDB.getConnection();
      System.out.println("Conexion Exitosa");
      cn.close();
      
      //login de usuario
      LogeoService login = new LogeoService();
      Empleado empleado = login.validar("roxy", "princesa");
      System.out.println("Hola: " + empleado.getNombre() + " " + empleado.getApellido());
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
  }
}
