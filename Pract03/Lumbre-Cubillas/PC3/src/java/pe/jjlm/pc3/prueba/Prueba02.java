package pe.jjlm.pc3.prueba;

import pe.jjlm.pc3.domain.Incidencia;
import pe.jjlm.pc3.service.IncidenciaService;

public class Prueba02 {
  public static void main(String[] args) {
    try {
      IncidenciaService service = new IncidenciaService();
      String local = "Miraflores";
      String gravedad = "Normal";
      
      for(Incidencia a: service.getListaLocalGravedad(local, gravedad)){
        System.out.println(a.getId() + "\t"+
                a.getLocal()+ "\t" +
                a.getTipo() + "\t" +
                a.getGravedad() + "\t" +
                a.getDescripcion() + "\t" +
                a.getFecha() + "\t" +
                a.getHora() + "\t" +
                a.getRecomendacion());
      }
      
      System.out.println("Proceso 0k.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
