/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CHRISTIAN
 */
public final class JdbcUtil {
    private JdbcUtil() {
  }
  
  public static List<Map<String, ?>> rsToList(ResultSet rs) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    List<Map<String, ?>> results = new ArrayList<>();
    while (rs.next()) {
      Map<String, Object> row = new HashMap<>();
      for (int i = 1; i <= columns; i++) {
        row.put(md.getColumnLabel(i).toUpperCase(), rs.getObject(i));
      }
      results.add(row);
    }
    return results;
  }
  
  public static Map<String, ?> rowToMap(ResultSet rs) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    Map<String, Object> row = new HashMap<>();
    for (int i = 1; i <= columns; i++) {
      row.put(md.getColumnLabel(i).toUpperCase(), rs.getObject(i));
    }
    return row;
  }
    
}
