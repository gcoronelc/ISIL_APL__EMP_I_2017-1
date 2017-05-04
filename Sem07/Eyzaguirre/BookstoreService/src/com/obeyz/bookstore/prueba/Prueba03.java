package com.obeyz.bookstore.prueba;

import com.obeyz.bookstore.model.Publicacion;
import com.obeyz.bookstore.service.VentaService;

/**
 *
 * @author benjamin
 */
public class Prueba03 {

  public static void main(String[] args) {
    try {
      // Dato                      
      String titulo = "Navicat for dummies";
      String autor = "Profesor Bustamante";
      Integer nroedicion = 1;
      Double precio = 20.0;
      Integer stock = 100;
      String idtipo = "LIB";

      Publicacion publicacion = new Publicacion("", titulo, autor, nroedicion, precio, stock, idtipo);

      // Proceso
      VentaService service = new VentaService();
      String idpublicacion = service.registrarNuevaPublicacion(publicacion);
      System.out.println(idpublicacion);

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

  }

}
