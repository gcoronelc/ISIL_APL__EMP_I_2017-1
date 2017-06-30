/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "reporte")
@NamedQueries({
  @NamedQuery(name = "Reporte.findAll", query = "select a from Reporte a")
})
public class Reporte implements Serializable {

  private static final long serialVersionUID = 3340106145531621062L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rep_id")
  private Integer id;
  
  @Column(name = "rep_local", length = 50, nullable = false)
  private String local;
  
  @Column(name = "rep_tipo", length = 50, nullable = false)
  private String tipo;
  
  @Column(name = "rep_gravedad")
  private String gravedad;
  
  @Column(name = "rep_descripcion")
  private String descripcion;
    
  @Column(name = "rep_fecha")
  private String fecha; 
  
  @Column(name = "hora")
  private String hora; 
    
  @Column(name = "Recomendacion")
  private String recomendacion;

  public Reporte() {
  }

  public Reporte(String local, String tipo, String gravedad,String descripcion, String fecha, String hora, String recomendacion) {
    this.local = local;
    this.tipo = tipo;
    this.gravedad = gravedad;
    this.descripcion = descripcion;
    this.fecha = fecha;
    this.hora = hora;
    this.recomendacion = recomendacion;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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



  public Object[] toRowData() {
    Object[] row;
    // row = new Object[]{this.getId(), this.getApellido(), this.getNombre(), this.getNota()};
    row = new Object[]{id, local, tipo, gravedad, descripcion, fecha, hora, recomendacion};
    return row;
  }
  
}
