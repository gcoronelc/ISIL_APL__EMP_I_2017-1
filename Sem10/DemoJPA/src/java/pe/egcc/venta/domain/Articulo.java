/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.venta.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alumno-CT
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
  @NamedQuery(name = "Articulo.findByArtId", query = "SELECT a FROM Articulo a WHERE a.artId = :artId"),
  @NamedQuery(name = "Articulo.findByArtCodigo", query = "SELECT a FROM Articulo a WHERE a.artCodigo = :artCodigo"),
  @NamedQuery(name = "Articulo.findByArtNombre", query = "SELECT a FROM Articulo a WHERE a.artNombre = :artNombre"),
  @NamedQuery(name = "Articulo.findByArtPrecio", query = "SELECT a FROM Articulo a WHERE a.artPrecio = :artPrecio"),
  @NamedQuery(name = "Articulo.findByArtStock", query = "SELECT a FROM Articulo a WHERE a.artStock = :artStock")})
public class Articulo implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "art_id")
  private Integer artId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "art_codigo")
  private String artCodigo;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "art_nombre")
  private String artNombre;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "art_precio")
  private BigDecimal artPrecio;
  @Basic(optional = false)
  @NotNull
  @Column(name = "art_stock")
  private int artStock;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId", fetch = FetchType.LAZY)
  private List<Detalle> detalleList;

  public Articulo() {
  }

  public Articulo(Integer artId) {
    this.artId = artId;
  }

  public Articulo(Integer artId, String artCodigo, String artNombre, BigDecimal artPrecio, int artStock) {
    this.artId = artId;
    this.artCodigo = artCodigo;
    this.artNombre = artNombre;
    this.artPrecio = artPrecio;
    this.artStock = artStock;
  }

  public Integer getArtId() {
    return artId;
  }

  public void setArtId(Integer artId) {
    this.artId = artId;
  }

  public String getArtCodigo() {
    return artCodigo;
  }

  public void setArtCodigo(String artCodigo) {
    this.artCodigo = artCodigo;
  }

  public String getArtNombre() {
    return artNombre;
  }

  public void setArtNombre(String artNombre) {
    this.artNombre = artNombre;
  }

  public BigDecimal getArtPrecio() {
    return artPrecio;
  }

  public void setArtPrecio(BigDecimal artPrecio) {
    this.artPrecio = artPrecio;
  }

  public int getArtStock() {
    return artStock;
  }

  public void setArtStock(int artStock) {
    this.artStock = artStock;
  }

  @XmlTransient
  public List<Detalle> getDetalleList() {
    return detalleList;
  }

  public void setDetalleList(List<Detalle> detalleList) {
    this.detalleList = detalleList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (artId != null ? artId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Articulo)) {
      return false;
    }
    Articulo other = (Articulo) object;
    if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(other.artId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.venta.domain.Articulo[ artId=" + artId + " ]";
  }
  
}
