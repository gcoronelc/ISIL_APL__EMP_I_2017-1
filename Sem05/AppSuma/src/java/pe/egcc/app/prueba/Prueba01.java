package pe.egcc.app.prueba;

import pe.egcc.app.service.SumaService;

public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    int n1 = 15;
    int n2 = 25;
    // Proceso
    SumaService service = new SumaService();
    int suma = service.sumar(n1, n2);
    // Reporte
    System.out.println("n1: " + n1);
    System.out.println("n2: " + n2);
    System.out.println("Suma: " + suma);
  }
  
  
}
