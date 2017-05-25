package pe.egcc.venta.prueba;

import java.util.ArrayList;
import java.util.List;
import pe.egcc.venta.domain.Articulo;
import pe.egcc.venta.model.VentaItem;
import pe.egcc.venta.service.VentaService;

public class Prueba04 {

  public static void main(String[] args) {
    try {
      // Items
      List<VentaItem> lista = new ArrayList<>();
      lista.add(new VentaItem(1L, "LAPTOP", 2000.0, 2L));
      lista.add(new VentaItem(2L, "LAVADORA", 4000.0, 3L));
      
      // Proceso
      VentaService service = new VentaService();
      service.procesarVenta(1L, lista);
      
      System.out.println("Proceso 0k.");
      
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

}
