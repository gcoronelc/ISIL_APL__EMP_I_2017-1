package isil.colegio.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AccesoDB {

  private AccesoDB() {
  }

  public static Connection getConnection() throws SQLException{
    // Dato para establecer la conexión
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://localhost:3306/colegiodb";
    String user = "eureka";
    String password = "admin";
    Connection cn = null;
    // Proceso
    try {
      // Paso 1: Cargar el driver
      Class.forName(driver).newInstance();
      // Obtener el objeto Connection
      cn = DriverManager.getConnection(urlDB, user, password);
    } catch (ClassNotFoundException e) {
      throw new SQLException("No se encontró el driver.");
    } catch (SQLException e) {
      throw e;
    } catch (Exception e) {
      throw new SQLException("No se puede establecer la conexión.");
    }
    // Retornar objeto Connection
    return cn;
  } 
  
}
