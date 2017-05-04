/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obeyz.bookstore.model;

/**
 *
 * @author benjamin
 */
public class Publicacion {
    private String idpublicacion;
    private String titulo;
    private String autor;
    private Integer nroedicion;
    private Double precio;
    private Integer stock;
    private String idtipo;

    public Publicacion(String idpublicacion, String titulo, String autor, Integer nroedicion, Double precio, Integer stock, String idtipo) {
        this.idpublicacion = idpublicacion;
        this.titulo = titulo;
        this.autor = autor;
        this.nroedicion = nroedicion;
        this.precio = precio;
        this.stock = stock;
        this.idtipo = idtipo;
    }

    public String getIdpublicacion() {
        return idpublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getNroedicion() {
        return nroedicion;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public String getIdtipo() {
        return idtipo;
    }

    public void setIdpublicacion(String idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNroedicion(Integer nroedicion) {
        this.nroedicion = nroedicion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }
    
    

    
    
    
}
