/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.isil.colegio.controller;

import isil.colegio.service.RegistroService;
import isil.colegio.service.VentaService;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
public class RegistroEstudiantes {
    
    public String nombre;
    public String apellido;
    public String apoderado;
    public String correo_apoderado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }

    public String getCorreo_apoderado() {
        return correo_apoderado;
    }

    public void setCorreo_apoderado(String correo_apoderado) {
        this.correo_apoderado = correo_apoderado;
    }


  

  public void doProcesar(){
    
    try{
      
        RegistroService service = new RegistroService();
        service.registrarEstudiante(nombre, apellido, apoderado, correo_apoderado);

    }catch(Exception e){
    
      FacesMessage message = new FacesMessage(
              FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", 
              e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, message);
      
    }     
                
  }
}
