package pe.egcc.app.prueba;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pe.egcc.app.domain.Organizacion;
import pe.egcc.app.domain.Proyecto;

public class Prueba03 {

  public static void main(String[] args) {
    List<String> rpta = new ArrayList<>();
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPARelaciones");
    EntityManager em = factory.createEntityManager();
    
    Query q = em.createQuery("select o from Organizacion o");
    
    for (Organizacion org : (List<Organizacion>) q.getResultList()) {
      
      rpta.add("Organizacion: " + org.getNombre());
      
      
      if (org.getIdOrganizacion() == 3 && org.getProyectos() != null && org.getProyectos().size() > 0 ) {
        for (Proyecto p : org.getProyectos()) {
          rpta.add(" - " + p.getNombre() + " asignado a " + p.getEstudiante().getNombre());
        }
      } else {
        rpta.add("No contiene proyectos todavia");
      }
      
      
    }
    em.close();
    factory.close();
    
    System.out.println("Lista de Organizaciones");
    for (String dato : rpta) {
      System.out.println(dato);
    }
  }

}
