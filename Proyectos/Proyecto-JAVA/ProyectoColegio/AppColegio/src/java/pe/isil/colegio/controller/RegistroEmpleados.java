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
public class RegistroEmpleados {
    
    public String usuario;
    public String clave;
    public String nombre;
    public String apellido;
    public String correo;
    public int idPer;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdPer() {
        return idPer;
    }

    public void setIdPer(int idPer) {
        this.idPer = idPer;
    }

              public void doProcesar(){
    
    try{
      
        RegistroService service = new RegistroService();
        service.registrarEmpleado(usuario, clave, nombre, apellido, correo, idPer);
     
      
         
    }catch(Exception e){
    
      FacesMessage message = new FacesMessage(
              FacesMessage.SEVERITY_ERROR, 
              "Error en el proceso.", 
              e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, message);
      
    }     
                
  }
}
