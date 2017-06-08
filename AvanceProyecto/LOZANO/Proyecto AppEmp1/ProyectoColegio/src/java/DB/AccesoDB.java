package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author HP de Franchesco
 */

public class AccesoDB {
    
  private AccesoDB() {
  }
  
  public static Connection getConnection() throws SQLException{
    // Parámetros
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://localhost:3306/colegio";
    String user = "root";
    String pass = "";
    // Variable
    Connection cnx = null;
    // Proceso
    try 
    {
      Class.forName(driver).newInstance();
      cnx = DriverManager.getConnection(urlDB, user, pass);
    } 
    catch (ClassNotFoundException e) 
    {
      throw new SQLException("No se ha encontrado el driver de BD.");
    } 
    catch(SQLException e)
    {
      throw e;
    } 
    catch(Exception e)
    {
      throw new SQLException("No se tiene acceso al servidor de BD.");
    }
    return cnx;
  } 
}
