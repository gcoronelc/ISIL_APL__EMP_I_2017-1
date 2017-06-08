package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DB.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class PermisoService {
  
  public static final String P_VENTAS = "VENTAS";
  public static final String P_PLANIFICACION = "PLANIFICACION";
  public static final String P_REPORTES = "REPORTES";
  public static final String P_SEGURIDAD = "SEGURIDAD";
  
  
  public int getPermiso(int idemp, String modulo)
  {
    int permiso = 0;
    Connection cn = null;
    try 
    {
      cn = AccesoDB.getConnection();
      String sql = "";
      switch(modulo)
      {
        case P_VENTAS:
          sql = "select IFNULL(sum(estado),0) cont from permiso where idrol in (1,2) and idemp = ?";
          break;
        case P_PLANIFICACION:
          sql = "select IFNULL(sum(estado),0) cont from permiso where idrol in (1,3) and idemp = ?";
          break;          
        case P_REPORTES:
          sql = "select IFNULL(sum(estado),0) cont from permiso where idrol in (1,3, 4) and idemp = ?";
          break;          
        case P_SEGURIDAD:
          sql = "select IFNULL(sum(estado),0) cont from permiso where idrol in (1) and idemp = ?";
          break;          
      }
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idemp);
      ResultSet rs = pstm.executeQuery();
      rs.next();
      permiso = rs.getInt("cont");
      rs.close();
      pstm.close();
    } 
    catch (Exception e) 
    {
      throw new RuntimeException("No se tiene acceso a los permisos.");
    }
    return permiso;
  }
  
}
