/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package pruebas;

import dao.ArticuloDAO;
import entity.Articulo;

public class PruebaArticulo01 {

  public static void main(String[] args) {
    
    Articulo articulo = new Articulo();
    articulo.setNombre("borrador");
    articulo.setPrecosto(0.50);
    articulo.setPreventa(2.0);
    articulo.setStock(100.0);

    try {
      ArticuloDAO dao = new ArticuloDAO();
      dao.create(articulo);
      System.out.println("ID: " + articulo.getId());
      System.out.println("Ok");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
