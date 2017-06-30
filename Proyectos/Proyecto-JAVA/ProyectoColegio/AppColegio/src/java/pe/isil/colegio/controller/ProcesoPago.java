

package pe.isil.colegio.controller;

import isil.colegio.service.VentaService;
import java.sql.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ProcesoPago {
    
        
    private int tipo;
    private double monto;
    private String fec_pago;
    private String fec_venc;
    private int est;
    private int mat;
    
    
  

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFec_pago() {
        return fec_pago;
    }

    public void setFec_pago(String fec_pago) {
        this.fec_pago = fec_pago;
    }

    public String getFec_venc() {
        return fec_venc;
    }

    public void setFec_venc(String fec_venc) {
        this.fec_venc = fec_venc;
    }

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    
          public void doProcesar(){
    
    try{
      
        VentaService service = new VentaService();
        
     
      service.registrarPago(tipo, monto, fec_pago, fec_venc, est, mat);
         
    }catch(Exception e){
    
      FacesMessage message = new FacesMessage(
              FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", 
              e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, message);
      
    }     
                
  }
    
}
