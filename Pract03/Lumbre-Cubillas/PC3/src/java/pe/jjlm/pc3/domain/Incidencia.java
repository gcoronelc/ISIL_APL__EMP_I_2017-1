package pe.jjlm.pc3.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INCIDENCIA")
public class Incidencia implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "inc_id")
  private Long id;
  @Column(name = "inc_local")
  private String local;
  @Column(name = "inc_tipo")
  private String tipo;
  @Column(name = "inc_gravedad")
  private String gravedad;
  @Column(name = "inc_descripcion")
  private String descripcion;
  @Column(name = "inc_fecha")
  private String fecha;
  @Column(name = "inc_hora")
  private String hora;
  @Column(name = "inc_recomendacion")
  private String recomendacion;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getGravedad() {
    return gravedad;
  }

  public void setGravedad(String gravedad) {
    this.gravedad = gravedad;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public String getRecomendacion() {
    return recomendacion;
  }

  public void setRecomendacion(String recomendacion) {
    this.recomendacion = recomendacion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Incidencia)) {
      return false;
    }
    Incidencia other = (Incidencia) object;
    if ((this.id == null && other.id != null)
            || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.jjlm.pc3.domain.Incidencia[id=" + id + "]";
  }
}
