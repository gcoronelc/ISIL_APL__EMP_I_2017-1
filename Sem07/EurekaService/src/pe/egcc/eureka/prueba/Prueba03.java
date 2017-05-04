package pe.egcc.eureka.prueba;

import java.util.List;
import java.util.Map;
import pe.egcc.eureka.service.CuentaService;

public class Prueba03 {

  public static void main(String[] args) {
    try {
      // Dato
      String cuenta = "00100001";
      // Proceso
      CuentaService service = new CuentaService();
      List<Map<String,?>> lista = service.conMovimientos(cuenta);
      if(lista.isEmpty()){
        throw new Exception("Cuenta no existe.");
      }
      // Reporte
      System.out.println("Cuenta: " + cuenta);
      System.out.println("Moneda: " + lista.get(0).get("MONENOMBRE"));
      System.out.println("Saldo: " + lista.get(0).get("CUENSALDO"));
      for (Map<String, ?> r : lista) {
        String repo = r.get("MOVINUMERO").toString() 
                + " - " + r.get("MOVIFECHA").toString()
                + " - " + r.get("TIPONOMBRE").toString()
                + " - " + r.get("MOVIIMPORTE");
        System.out.println(repo);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
