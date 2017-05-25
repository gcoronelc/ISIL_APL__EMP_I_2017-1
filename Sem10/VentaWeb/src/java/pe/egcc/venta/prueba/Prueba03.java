package pe.egcc.venta.prueba;

import pe.egcc.venta.domain.Articulo;
import pe.egcc.venta.service.VentaService;

public class Prueba03 {

  public static void main(String[] args) {
    try {
      VentaService service = new VentaService();
      Articulo a = service.getArticulo(4L);
      System.out.println("ID: " + a.getId());
      System.out.println("NOMBRE: " + a.getNombre());
      System.out.println("PRECIO: " + a.getPrecio());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

}
