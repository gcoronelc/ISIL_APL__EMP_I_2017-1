package com.obeyz.bookstore.prueba;

import com.obeyz.bookstore.service.VentaService;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benjamin
 */
public class Prueba02 {

  public static void main(String[] args) {
    try {
      // Dato
      String tipo = "LIB";
      // Proceso
      VentaService service = new VentaService();
      List< Map< String, ?>> lista = service.ventasPorTipoPublicacion(tipo);
      if (lista.isEmpty()) {
        throw new Exception("Tipo no existe.");
      }
      // Reporte
      for (Map< String, ?> r : lista) {
        System.out.println(r);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
