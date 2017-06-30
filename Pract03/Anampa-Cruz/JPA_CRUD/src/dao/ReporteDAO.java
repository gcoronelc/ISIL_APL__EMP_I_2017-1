/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package dao;

import entity.Reporte;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ReporteDAO {

  private EntityManagerFactory emf;

  public ReporteDAO() {
    this.emf = Persistence.createEntityManagerFactory("JPAReporte");
  }

  // Crea un nuevo alumno en la tabla alumno.
  public void create(Reporte entity) throws Exception {
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    try {
      entr.begin();
      em.persist(entity);
      entr.commit();
      em.close();
    } catch (Exception e) {
      try {
        entr.rollback();
        em.close();
      } catch (Exception e1) {
      }
      throw e;
    }
  }

  // Lee un alumno desde la tabla alumno
  public Reporte read(int id) throws Exception {
    EntityManager em = emf.createEntityManager();
    Reporte alu = em.find(Reporte.class, id);
    return alu;
  }

  // Utilizando Dynamic Query
  public List<Reporte> readAll1() throws Exception {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("select a from Reporte a");
    List<Reporte> lista = query.getResultList();
    return lista;
  }

  // Utilizando Named Query
  public List<Reporte> readAll2() throws Exception {
    EntityManager em = emf.createEntityManager();
    Query query = em.createNamedQuery("Reporte.findAll");
    List<Reporte> lista = query.getResultList();
    return lista;
  }
  
  // Consulta con parámetros
  public List<Reporte> readForName(String name) throws Exception {
    EntityManager em = emf.createEntityManager();
    String sql = "select a from Reporte a "
            + "where a.local like :local";
    Query query = em.createQuery(sql);
    query.setParameter("local", name + "%");
    List<Reporte> lista = query.getResultList();
    return lista;
  }

  // Actualiza los datos de un alumno
  public void update(Reporte entity) throws Exception {
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    try {
      entr.begin();
      em.merge(entity);
      entr.commit();
      em.close();
    } catch (Exception e) {
      try {
        entr.rollback();
        em.close();
      } catch (Exception e1) {
      }
      throw e;
    }
  }

  // Elimina un alumno de la tabla
  public void delete(Integer id) throws Exception {
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    try {
      entr.begin();
      Reporte report = em.find(Reporte.class, id);
      em.remove(report);
      entr.commit();
      em.close();
    } catch (Exception e) {
      try {
        entr.rollback();
        em.close();
      } catch (Exception e1) {
      }
      throw e;
    }
  }
}
