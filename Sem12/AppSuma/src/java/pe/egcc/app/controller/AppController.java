package pe.egcc.app.controller;

import javax.faces.bean.ManagedBean;
import pe.egcc.app.service.AppService;

@ManagedBean
public class AppController {
  
  // Datos
  private int num1;
  private int num2;
  
  // Resultado
  private int suma;

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getSuma() {
    return suma;
  }

  
  // Procesos
  public void doSumar(){
    AppService service = new AppService();
    suma = service.sumar(num1, num2);
  }
  
  
}
