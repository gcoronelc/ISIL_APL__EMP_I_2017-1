/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.venta.domain;

import java.io.Serializable;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
  @NamedQuery(name = "Cliente.findByCliId", query = "SELECT c FROM Cliente c WHERE c.cliId = :cliId"),
  @NamedQuery(name = "Cliente.findByCliNombre", query = "SELECT c FROM Cliente c WHERE c.cliNombre = :cliNombre")})
public class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "cli_id")
  private Integer cliId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "cli_nombre")
  private String cliNombre;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliId", fetch = FetchType.LAZY)
  private List<Venta> ventaList;

  public Cliente() {
  }

  public Cliente(Integer cliId) {
    this.cliId = cliId;
  }

  public Cliente(Integer cliId, String cliNombre) {
    this.cliId = cliId;
    this.cliNombre = cliNombre;
  }

  public Integer getCliId() {
    return cliId;
  }

  public void setCliId(Integer cliId) {
    this.cliId = cliId;
  }

  public String getCliNombre() {
    return cliNombre;
  }

  public void setCliNombre(String cliNombre) {
    this.cliNombre = cliNombre;
  }

  @XmlTransient
  public List<Venta> getVentaList() {
    return ventaList;
  }

  public void setVentaList(List<Venta> ventaList) {
    this.ventaList = ventaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cliId != null ? cliId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cliente)) {
      return false;
    }
    Cliente other = (Cliente) object;
    if ((this.cliId == null && other.cliId != null) || (this.cliId != null && !this.cliId.equals(other.cliId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.venta.domain.Cliente[ cliId=" + cliId + " ]";
  }
  
}
