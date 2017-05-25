package pe.egcc.venta.prueba;

import pe.egcc.venta.domain.Articulo;
import pe.egcc.venta.service.VentaService;

public class Prueba02 {

  public static void main(String[] args) {
    try {
      VentaService service = new VentaService();
      for(Articulo a: service.getListaArticulos()){
        System.out.println(a.getId() + "\t" + a.getNombre() + "\t" + a.getPrecio());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
