package pe.egcc.venta.prueba;

import pe.egcc.venta.domain.Cliente;
import pe.egcc.venta.service.VentaService;

public class Prueba01 {

  public static void main(String[] args) {
    try {
      VentaService service = new VentaService();
      for(Cliente c: service.getListaClientes()){
        System.out.println(c.getId() + "\t" + c.getNombre());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
