/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.service.ListaEmpleadosService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class ListaEmpleados {
    
              public static void main(String[] args) {
    try {
      // Dato
      String apPaterno = "Romero";
      // Proceso
        ListaEmpleadosService service = new ListaEmpleadosService();
      List<Map<String,?>> lista = service.listarEmpleados();
      if(lista.isEmpty()){
        throw new Exception("Cuenta no existe.");
      }
      // Reporte
      System.out.println("Apellido Paterno: " + apPaterno);
     /* System.out.println("Titulo: " + lista.get(0).get("TITULO"));
      System.out.println("autor: " + lista.get(0).get("AUTOR"));*/
      for (Map<String, ?> r : lista) {
        String repo = r.get("IDEMP").toString() 
                   + " - " + r.get("USUARIO").toString()
                + " - " + r.get("CLAVE").toString()
                + " - " + r.get("NOMBRE_EMP").toString()
                  + " - " + r.get("APELLIDO_EMP").toString()
                + " - " + r.get("CORREO").toString()
                + " - " + r.get("IDPER").toString();
        System.out.println(repo);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }  
    
}
