/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.isil.colegio.controller;

import isil.colegio.service.ListaEmpleadosService;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */

@ManagedBean
public class ListaEmpleados {
    
      private java.util.List<Map<String, ?>> lista;

    public List<Map<String, ?>> getLista() {
        return lista;
    }

    public void setLista(List<Map<String, ?>> lista) {
        this.lista = lista;
    }
    
         public void doProcesar(){
    
    try{
      
        ListaEmpleadosService service = new ListaEmpleadosService();
      lista = service.listarEmpleados();
      
    }catch(Exception e){
    
      FacesMessage message = new FacesMessage(
              FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", 
              e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, message);
      
    }     
                
  }
    
}
