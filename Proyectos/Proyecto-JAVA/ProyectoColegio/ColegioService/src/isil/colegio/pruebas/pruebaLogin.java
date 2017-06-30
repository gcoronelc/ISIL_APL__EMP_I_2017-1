/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.service.ValidarUsuarioService;

/**
 *
 * @author Usuario
 */
public class pruebaLogin {
        
    public static void main(String[] args) {
        
        
          ValidarUsuarioService service = new ValidarUsuarioService();
          System.out.println(service.autenticar("pachito", "456"));
    }
      
}
