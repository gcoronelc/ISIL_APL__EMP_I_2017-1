package pe.egcc.app.prueba;

import pe.egcc.app.service.AppService;

public class Prueba01 {

  public static void main(String[] args) {
    
    // Datos
    int n1 = 70;
    int n2 = 50;
    
    // Proceso
    AppService service = new AppService();
    int suma = service.sumar(n1, n2);
    
    // Reporte
    System.out.println("n1: " + n1);
    System.out.println("n2: " + n2);
    System.out.println("Suma: " + suma);
    
  }
  
}
