
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.AlumnoDAO;
import entity.Alumno;

public class Prueba04 {

	public static void main(String[] args) {
    
		Alumno alumno = new Alumno();
		alumno.setApellido("Coronel");
    alumno.setNombre("ERIC");
    alumno.setNota(20);
    alumno.setId(3);

		try {
			AlumnoDAO dao = new AlumnoDAO();
			dao.update(alumno);
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
