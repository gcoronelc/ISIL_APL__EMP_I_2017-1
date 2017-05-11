/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package pruebas;

import dao.AlumnoDAO;
import entity.Alumno;

public class Prueba01 {

  public static void main(String[] args) {
    
    Alumno alumno = new Alumno();
    alumno.setApellido("CORONEL");
    alumno.setNombre("GUSTAVO");
    alumno.setNota(20);

    try {
      AlumnoDAO dao = new AlumnoDAO();
      dao.create(alumno);
      System.out.println("ID: " + alumno.getId());
      System.out.println("Ok");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
