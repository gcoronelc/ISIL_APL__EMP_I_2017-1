package pe.egcc.eureka.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import pe.egcc.eureka.service.CuentaService;

@ManagedBean
public class ConsultaSaldo {

  private String cuenta;
  private double saldo;

  public String getCuenta() {
    return cuenta;
  }

  public void setCuenta(String cuenta) {
    this.cuenta = cuenta;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
  
  
  public void doProcesar(){
    
    try{
      
      CuentaService service = new CuentaService();
      saldo = service.conSaldoCuenta(cuenta);
      
    }catch(Exception e){
    
      FacesMessage message = new FacesMessage(
              FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", 
              e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, message);
      
    }     
                
  }
  
}
