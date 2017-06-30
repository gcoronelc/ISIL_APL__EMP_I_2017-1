/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.service.RegistroService;
import isil.colegio.service.ValidarUsuarioService;
import isil.colegio.service.VentaService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class ObtenerDatos {
    
    public static void main(String[] args) {
    try {
      // Dato
   
      // Proceso
        ValidarUsuarioService service = new ValidarUsuarioService();
      List<Map<String,?>> lista = service.obtenerDatos("cbus","123");
      if(lista.isEmpty()){
        throw new Exception("Usuario no existe.");
      }
      // Reporte
    
 
      for (Map<String, ?> r : lista) {
        String repo = r.get("IDPER").toString() ;
        System.out.println(repo);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
    
}
