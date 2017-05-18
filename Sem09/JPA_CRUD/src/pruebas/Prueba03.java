
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.AlumnoDAO;
import entity.Alumno;

public class Prueba03 {

	public static void main(String[] args) {
    
    Alumno alumno = new Alumno();
		alumno.setId(1);
		alumno.setApellido("SARGENTO");
		alumno.setNombre("RICARDO");
		alumno.setNota(39);

		try {
			AlumnoDAO dao = new AlumnoDAO();
			dao.update(alumno);
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
