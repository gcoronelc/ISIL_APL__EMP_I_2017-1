
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.ReporteDAO;
import entity.Reporte;

public class Prueba03 {

	public static void main(String[] args) {
    
    Reporte report = new Reporte();
    report.setId(1);       
    report.setLocal("San Isidro");
    report.setTipo("Academica");
    report.setGravedad("Grave");
    report.setDescripcion("El profesor no asistira a clase");
    report.setFecha("08/06/2017");
    report.setHora("20:00");
    report.setRecomendacion("comunicarse con el profesor");
		try {
			ReporteDAO dao = new ReporteDAO();
			dao.update(report);
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
