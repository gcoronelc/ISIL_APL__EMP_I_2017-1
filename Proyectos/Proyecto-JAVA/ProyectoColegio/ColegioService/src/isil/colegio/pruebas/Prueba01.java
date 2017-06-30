/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isil.colegio.pruebas;

import isil.colegio.service.VentaService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CHRISTIAN
 */
public class Prueba01 {
    public static void main(String[] args) {
    try {
      // Dato
      String cuenta = "1";
      // Proceso
        VentaService service = new VentaService();
      List<Map<String,?>> lista = service.PagosPorEstudiante(cuenta);
      if(lista.isEmpty()){
        throw new Exception("Cuenta no existe.");
      }
      // Reporte
      System.out.println("Cuenta: " + cuenta);
 
      for (Map<String, ?> r : lista) {
        String repo = r.get("NOMBRE_EST").toString() 
                + " - " + r.get("APELLIDO_EST").toString()
                + " - " + r.get("CORREO_APO").toString()
                + " - " + r.get("MONTO")
                 + " - " + r.get("FEC_VENCIM");
        System.out.println(repo);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
    
}
