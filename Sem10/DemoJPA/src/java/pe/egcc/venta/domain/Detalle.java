/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.venta.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno-CT
 */
@Entity
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d"),
  @NamedQuery(name = "Detalle.findByDetId", query = "SELECT d FROM Detalle d WHERE d.detId = :detId"),
  @NamedQuery(name = "Detalle.findByDetPrecio", query = "SELECT d FROM Detalle d WHERE d.detPrecio = :detPrecio"),
  @NamedQuery(name = "Detalle.findByDetCantidad", query = "SELECT d FROM Detalle d WHERE d.detCantidad = :detCantidad"),
  @NamedQuery(name = "Detalle.findByDetSubtotal", query = "SELECT d FROM Detalle d WHERE d.detSubtotal = :detSubtotal")})
public class Detalle implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "det_id")
  private Integer detId;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "det_precio")
  private BigDecimal detPrecio;
  @Basic(optional = false)
  @NotNull
  @Column(name = "det_cantidad")
  private int detCantidad;
  @Basic(optional = false)
  @NotNull
  @Column(name = "det_subtotal")
  private BigDecimal detSubtotal;
  @JoinColumn(name = "art_id", referencedColumnName = "art_id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Articulo artId;
  @JoinColumn(name = "ven_id", referencedColumnName = "ven_id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Venta venId;

  public Detalle() {
  }

  public Detalle(Integer detId) {
    this.detId = detId;
  }

  public Detalle(Integer detId, BigDecimal detPrecio, int detCantidad, BigDecimal detSubtotal) {
    this.detId = detId;
    this.detPrecio = detPrecio;
    this.detCantidad = detCantidad;
    this.detSubtotal = detSubtotal;
  }

  public Integer getDetId() {
    return detId;
  }

  public void setDetId(Integer detId) {
    this.detId = detId;
  }

  public BigDecimal getDetPrecio() {
    return detPrecio;
  }

  public void setDetPrecio(BigDecimal detPrecio) {
    this.detPrecio = detPrecio;
  }

  public int getDetCantidad() {
    return detCantidad;
  }

  public void setDetCantidad(int detCantidad) {
    this.detCantidad = detCantidad;
  }

  public BigDecimal getDetSubtotal() {
    return detSubtotal;
  }

  public void setDetSubtotal(BigDecimal detSubtotal) {
    this.detSubtotal = detSubtotal;
  }

  public Articulo getArtId() {
    return artId;
  }

  public void setArtId(Articulo artId) {
    this.artId = artId;
  }

  public Venta getVenId() {
    return venId;
  }

  public void setVenId(Venta venId) {
    this.venId = venId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (detId != null ? detId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Detalle)) {
      return false;
    }
    Detalle other = (Detalle) object;
    if ((this.detId == null && other.detId != null) || (this.detId != null && !this.detId.equals(other.detId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.venta.domain.Detalle[ detId=" + detId + " ]";
  }
  
}
