/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.isil.colegio.controller;

import isil.colegio.service.VentaService;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author CHRISTIAN
 */

@ManagedBean
public class RegistroIngreso {
    VentaService service = new VentaService();
       
     
    private int idest;
    private List<Map<String, ?>> lista = service.getEstudiantesIngreso();

    public List<Map<String, ?>> getLista() {
        return lista;
    }

    public void setLista(List<Map<String, ?>> lista) {
        this.lista = lista;
    }
  

    public int getIdest() {
        return idest;
    }

    public void setIdest(int idest) {
        this.idest = idest;
    }

       
  
    
    public void doProcesar(){
         try{
      
     
        
      service.regIngreso(idest);
      
      
    }catch(Exception e){
    
      FacesMessage message = new FacesMessage(
              FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", 
              e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, message);
      
    }     
    
    }
    
    
    
}
