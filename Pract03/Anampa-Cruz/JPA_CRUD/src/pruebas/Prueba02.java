/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package pruebas;

import dao.ReporteDAO;
import entity.Reporte;

public class Prueba02 {

  public static void main(String[] args) {

    try {
      ReporteDAO dao = new ReporteDAO();
      Reporte report = dao.read(1);
      System.out.println("ID: " + report.getId());
      System.out.println("Local: " + report.getLocal());
      System.out.println("Tipo de incidencia: " + report.getTipo());
      System.out.println("Gravedad de la incidencia: " + report.getGravedad());
      System.out.println("Descripcion: "+report.getDescripcion());
      System.out.println("Hora: "+report.getHora());
      System.out.println("Fecha: "+report.getFecha());
      System.out.println("Recomendacion: "+report.getRecomendacion());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
