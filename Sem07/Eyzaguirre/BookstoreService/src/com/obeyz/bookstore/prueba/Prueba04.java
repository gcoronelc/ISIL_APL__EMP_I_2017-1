/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obeyz.bookstore.prueba;

import com.obeyz.bookstore.model.Venta;
import com.obeyz.bookstore.service.VentaService;

/**
 *
 * @author benjamin
 */
public class Prueba04 {
    public static void main(String[] args) {
        String cliente = "ISIL";
        Integer idempleado = 5;
        String idpublicacion = "LIB00001";
        Integer cantidad = 10;
        
        
        Venta venta = new Venta(null, cliente, null, idempleado, idpublicacion, cantidad, null, null, null, null, null);
        // Proceso
        VentaService service = new VentaService();            
        Integer idventa = service.efectuarVenta(venta);
        System.out.println(idventa);
    }
}
