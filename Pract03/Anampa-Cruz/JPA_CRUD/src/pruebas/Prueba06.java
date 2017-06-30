
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.ReporteDAO;
import entity.Reporte;
import java.util.List;

public class Prueba06 {

	public static void main(String[] args) {
		List<Reporte> lista = null;

		try {
			ReporteDAO dao = new ReporteDAO();
			lista = dao.readForName("g");
			for (Reporte report : lista) {
				System.out.println(report.getId() + " - " +
						  report.getLocal() + " - " +
						  report.getTipo()+ " - " +
						  report.getGravedad()+ " - " +
                                                  report.getDescripcion()+ " - " +
                                                  report.getFecha()+ " - " +
                                                  report.getHora()+ " - " +
                                                  report.getRecomendacion());
			}
		} catch (Exception e) {
      e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}