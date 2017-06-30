/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.isil.colegio.controller;

import isil.colegio.service.ValidarUsuarioService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
public class ValidarLogin {
    
    private String usuario;
     private String pass;
     private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
   
        
    public int recuperaDatos() throws Exception
    {
     int rpta=0;
      ValidarUsuarioService datos = new ValidarUsuarioService();
      List<Map<String,?>> lista = datos.obtenerDatos(usuario,pass);
      if(lista.isEmpty()){
        throw new Exception("Usuario no existe.");
      }
      for (Map<String, ?> r : lista) {
        String IDPER = r.get("IDPER").toString();
        rpta = Integer.parseInt(IDPER);
      }
        return rpta;
    }
    
    public void validarLogin () throws IOException, Exception
    {
     
        ValidarUsuarioService service = new ValidarUsuarioService();
        boolean acceso;
        acceso=service.autenticar(usuario, pass);
      
        if(acceso)
        {
            if(recuperaDatos()==1){
          ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
          externalContext.redirect("index.xhtml");
            }
            else if(recuperaDatos()==2){
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
          externalContext.redirect("index_secret.xhtml");
            }
        }
        else
        {
        
            mensaje = "Usuario no existe o la contraseña es incorrecta";
        
        }
    
    }
}
