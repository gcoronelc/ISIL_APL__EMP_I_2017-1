package pe.egcc.eureka.prueba;

import pe.egcc.eureka.service.CuentaService;

public class Prueba04 {

  public static void main(String[] args) {
    
    try {
      // Datos
      String cuenta = "00100001";
      double importe = 200.0;
      String codEmp = "0003";
      // Proceso
      CuentaService service = new CuentaService();
      int nroMov = service.procDeposito(cuenta, importe, codEmp);
      // Reporte
      System.out.println("Nro. Mov. " + nroMov);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    
    
    
  }
  
}
