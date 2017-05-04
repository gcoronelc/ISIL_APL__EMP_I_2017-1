/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obeyz.bookstore.model;

import java.sql.Date;

/**
 *
 * @author benjamin
 */
public class Venta {
    private Integer idventa;
    private String cliente;
    private Date fecha;
    private Integer idempleado;
    private String idpublicacion;
    private Integer cantidad;
    private Double precio;
    private Double dcto;
    private Double subtotal;
    private Double impuesto;
    private Double total;

    public Venta(Integer idventa, String cliente, Date fecha, Integer idempleado, String idpublicacion, Integer cantidad, Double precio, Double dcto, Double subtotal, Double impuesto, Double total) {
        this.idventa = idventa;
        this.cliente = cliente;
        this.fecha = fecha;
        this.idempleado = idempleado;
        this.idpublicacion = idpublicacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.dcto = dcto;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(String idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getDcto() {
        return dcto;
    }

    public void setDcto(Double dcto) {
        this.dcto = dcto;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
    
}
