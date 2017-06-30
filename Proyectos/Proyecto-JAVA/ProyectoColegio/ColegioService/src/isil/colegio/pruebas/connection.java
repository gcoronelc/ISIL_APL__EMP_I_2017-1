/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.db.AccesoDB;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class connection {
    
    
    
  public static void main(String[] args) {
    try {
      Connection cn = AccesoDB.getConnection();
      System.out.println("Ok");
      cn.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
