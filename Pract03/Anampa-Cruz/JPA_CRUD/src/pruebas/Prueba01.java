/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package pruebas;

import dao.ReporteDAO;
import entity.Reporte;

public class Prueba01 {

  public static void main(String[] args) {
    
    Reporte report = new Reporte();
    report.setLocal("Miraflores");
    report.setTipo("Administrativa");
    report.setGravedad("Nommal");
    report.setDescripcion("No hay sistema");
    report.setFecha("08/06/2017");
    report.setHora("10:30");
    report.setRecomendacion("arreglarlo");
    
    try {
      ReporteDAO dao = new ReporteDAO();
      dao.create(report);
      System.out.println("ID: " + report.getId());
      System.out.println("Ok");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
