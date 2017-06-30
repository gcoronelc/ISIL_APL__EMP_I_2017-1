
package pe.jjlm.pc3.prueba;

import pe.jjlm.pc3.model.IncidenciaModel;
import pe.jjlm.pc3.service.IncidenciaService;

public class Prueba01 {
  public static void main(String[] args) {
    try {
      IncidenciaService service = new IncidenciaService();
      
      IncidenciaModel inc = new IncidenciaModel();
      inc.setLocal("Miraflores");
      inc.setTipo("Estudiantil");
      inc.setGravedad("Normal");
      inc.setDescripcion("El mouse no funciona");
      inc.setRecomendacion("Verificar periodicamente los perifericos.");
      
      service.registrarIncidencia(1L, inc);
      
      System.out.println("Proceso 0k.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
