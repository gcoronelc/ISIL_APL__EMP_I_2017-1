/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.venta.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alumno-CT
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
  @NamedQuery(name = "Venta.findByVenId", query = "SELECT v FROM Venta v WHERE v.venId = :venId"),
  @NamedQuery(name = "Venta.findByVenFecha", query = "SELECT v FROM Venta v WHERE v.venFecha = :venFecha"),
  @NamedQuery(name = "Venta.findByVenSubtotal", query = "SELECT v FROM Venta v WHERE v.venSubtotal = :venSubtotal"),
  @NamedQuery(name = "Venta.findByVenImpuesto", query = "SELECT v FROM Venta v WHERE v.venImpuesto = :venImpuesto"),
  @NamedQuery(name = "Venta.findByVenTotal", query = "SELECT v FROM Venta v WHERE v.venTotal = :venTotal")})
public class Venta implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ven_id")
  private Integer venId;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ven_fecha")
  @Temporal(TemporalType.TIMESTAMP)
  private Date venFecha;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "ven_subtotal")
  private BigDecimal venSubtotal;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ven_impuesto")
  private BigDecimal venImpuesto;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ven_total")
  private BigDecimal venTotal;
  @JoinColumn(name = "cli_id", referencedColumnName = "cli_id")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Cliente cliId;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "venId", fetch = FetchType.LAZY)
  private List<Detalle> detalleList;

  public Venta() {
  }

  public Venta(Integer venId) {
    this.venId = venId;
  }

  public Venta(Integer venId, Date venFecha, BigDecimal venSubtotal, BigDecimal venImpuesto, BigDecimal venTotal) {
    this.venId = venId;
    this.venFecha = venFecha;
    this.venSubtotal = venSubtotal;
    this.venImpuesto = venImpuesto;
    this.venTotal = venTotal;
  }

  public Integer getVenId() {
    return venId;
  }

  public void setVenId(Integer venId) {
    this.venId = venId;
  }

  public Date getVenFecha() {
    return venFecha;
  }

  public void setVenFecha(Date venFecha) {
    this.venFecha = venFecha;
  }

  public BigDecimal getVenSubtotal() {
    return venSubtotal;
  }

  public void setVenSubtotal(BigDecimal venSubtotal) {
    this.venSubtotal = venSubtotal;
  }

  public BigDecimal getVenImpuesto() {
    return venImpuesto;
  }

  public void setVenImpuesto(BigDecimal venImpuesto) {
    this.venImpuesto = venImpuesto;
  }

  public BigDecimal getVenTotal() {
    return venTotal;
  }

  public void setVenTotal(BigDecimal venTotal) {
    this.venTotal = venTotal;
  }

  public Cliente getCliId() {
    return cliId;
  }

  public void setCliId(Cliente cliId) {
    this.cliId = cliId;
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
    hash += (venId != null ? venId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Venta)) {
      return false;
    }
    Venta other = (Venta) object;
    if ((this.venId == null && other.venId != null) || (this.venId != null && !this.venId.equals(other.venId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.venta.domain.Venta[ venId=" + venId + " ]";
  }
  
}
