/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.service.VentaService;



/**
 *
 * @author CHRISTIAN
 */
public class Prueba02 {
    
    public static void main(String[] args) {
        
        try{
            
            VentaService service = new VentaService();
            service.registrarPago(2, 100, "17/06/05","17/06/05",2,2);
        
        
        }
       catch (Exception e) {
      System.err.println(e.getMessage());
    }
    
}
}
