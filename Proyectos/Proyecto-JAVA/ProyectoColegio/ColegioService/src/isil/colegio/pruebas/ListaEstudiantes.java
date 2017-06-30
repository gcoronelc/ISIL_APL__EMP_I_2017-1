/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.service.ListaEmpleadosService;
import isil.colegio.service.ListaEstudianteService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class ListaEstudiantes {
 
              public static void main(String[] args) {
    try {

      ListaEstudianteService service = new ListaEstudianteService();
      List<Map<String,?>> lista = service.listarEstudiantes();
      if(lista.isEmpty()){
        throw new Exception("Cuenta no existe.");
      }

      for (Map<String, ?> r : lista) {
        String repo = r.get("IDEST").toString() 
                   + " - " + r.get("NOMBRE_EST").toString()
                + " - " + r.get("APELLIDO_EST").toString()
                + " - " + r.get("APODERADO").toString()
                  + " - " + r.get("CORREO_APO").toString();
         System.out.println(repo);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }  
    
}
