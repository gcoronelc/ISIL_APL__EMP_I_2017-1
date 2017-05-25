package pe.egcc.app.prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pe.egcc.app.domain.Estudiante;
import pe.egcc.app.domain.Organizacion;
import pe.egcc.app.domain.Proyecto;

public class Prueba01 {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPARelaciones");
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();
    
    Organizacion organizacion = new Organizacion("The Apache Software Foundation");
    
    
    Proyecto proyecto = new Proyecto("Streaming LOB support (for OpenJPA)");
    
    Estudiante estudiante = new Estudiante("Ignacio Andreu");
    estudiante.setProyecto(proyecto);
    proyecto.setEstudiante(estudiante);
    proyecto.setOrganizacion(organizacion);
    organizacion.addProyecto(proyecto);
    
    //em.persist(estudiante);
    //em.persist(organizacion);
    em.persist(proyecto);
    
    proyecto = new Proyecto("Maven Dependency Visualization");
    estudiante = new Estudiante("Peter Kolbus");
    estudiante.setProyecto(proyecto);
    proyecto.setEstudiante(estudiante);
    proyecto.setOrganizacion(organizacion);
    organizacion.addProyecto(proyecto);
    
    //em.persist(estudiante);
    //em.persist(organizacion);
    em.persist(proyecto);
    
    organizacion = new Organizacion("Mono Proyecto");
    proyecto = new Proyecto("Gendarme Tasks");
    estudiante = new Estudiante("Néstor Salceda");
    estudiante.setProyecto(proyecto);
    proyecto.setEstudiante(estudiante);
    proyecto.setOrganizacion(organizacion);
    organizacion.addProyecto(proyecto);
    
    em.persist(estudiante);
    em.persist(organizacion);
    em.persist(proyecto);
    
    em.getTransaction().commit();
    em.close();
    factory.close();
    
  }

}
