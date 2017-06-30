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
 * @author Usuario
 */
@ManagedBean
public class ConsultarPagos {
    
      private java.util.List<Map<String, ?>> lista;
       private String idAlumno;

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public List<Map<String, ?>> getLista() {
        return lista;
    }

    public void setLista(List<Map<String, ?>> lista) {
        this.lista = lista;
    }


    
      public void doProcesar(){
    
    try{
      
        VentaService service = new VentaService();
      lista = service.PagosPorEstudiante(idAlumno);
      
    }catch(Exception e){
    
      FacesMessage message = new FacesMessage(
              FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", 
              e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, message);
      
    }                 
  }
}


