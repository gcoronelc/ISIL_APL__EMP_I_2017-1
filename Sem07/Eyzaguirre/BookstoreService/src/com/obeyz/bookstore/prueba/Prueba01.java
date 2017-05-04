/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obeyz.bookstore.prueba;

import com.obeyz.bookstore.db.AccesoDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benjamin
 */
public class Prueba01 {
    public static void main(String[] args) {
        try {
            Connection con = AccesoDB.getConnection();
            System.out.println("ok");
        } catch (SQLException ex) {
            Logger.getLogger(Prueba01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
