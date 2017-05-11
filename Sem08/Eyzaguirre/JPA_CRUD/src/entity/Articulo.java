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
@Table(name = "articulo")
@NamedQueries({
  @NamedQuery(name = "Articulo.findAll", query = "select a from Articulo a")
})
public class Articulo implements Serializable {

  private static final long serialVersionUID = 3340106145531621062L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "art_id")
  private Integer id;
  
  @Column(name = "art_nombre", length = 50, nullable = false)
  private String nombre;
  
  @Column(name = "art_preciocosto", nullable = false)
  private Double precosto;
  
  @Column(name = "art_precioventa", nullable = false)
  private Double preventa;
  
  @Column(name = "art_stock", nullable = false)
  private Double stock;
  

  public Articulo() {
  }

    public Articulo(String nombre, Double precosto, Double preventa, Double stock) {
        this.nombre = nombre;
        this.precosto = precosto;
        this.preventa = preventa;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecosto() {
        return precosto;
    }

    public void setPrecosto(Double precosto) {
        this.precosto = precosto;
    }

    public Double getPreventa() {
        return preventa;
    }

    public void setPreventa(Double preventa) {
        this.preventa = preventa;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

  

  public Object[] toRowData() {
    Object[] row;
    row = new Object[]{this.getId(), this.getNombre(), this.getPrecosto(), this.getPreventa(), this.getStock()};
    return row;
  }
}
