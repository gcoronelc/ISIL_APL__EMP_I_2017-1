package pe.jjlm.pc3.model;
import java.sql.Time;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

public class IncidenciaModel {

  private Long id;
  private String local;
  private String tipo;
  private String gravedad;
  private String descripcion;
  private String fecha;
  private String hora;
  private String recomendacion;

  public IncidenciaModel() {
  }
  
  public IncidenciaModel(Long id, String local, String tipo, String gravedad, String descripcion,
  String fecha, String hora, String recomendacion){
     this.id = id;
    this.local = local;
    this.tipo = tipo;
    this.gravedad = gravedad;
    this.descripcion = descripcion;
    this.fecha = fecha;
    this.hora = hora;
    this.recomendacion = recomendacion;
  }

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
}
