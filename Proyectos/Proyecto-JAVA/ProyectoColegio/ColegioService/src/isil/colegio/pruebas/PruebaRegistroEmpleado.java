/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.service.RegistroService;
import isil.colegio.service.VentaService;

/**
 *
 * @author Usuario
 */
public class PruebaRegistroEmpleado {
    
    public static void main(String[] args) {
            try{
            
            RegistroService service = new RegistroService();
            service.registrarEmpleado("cperez","123","juan","perez","jperez@gmail.com",2);
            
          /* RegistroService service = new RegistroService();
            service.registrarEstudiante("daniel","curais","Sergio Malaga","sg@hotmail.com");*/
        
        }
       catch (Exception e) {
      System.err.println(e.getMessage());
    }
            
    }
    
}
