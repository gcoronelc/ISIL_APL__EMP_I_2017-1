/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package dao;

import entity.Articulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ArticuloDAO {

  private EntityManagerFactory emf;

  public ArticuloDAO() {
    this.emf = Persistence.createEntityManagerFactory("JpaPanchito");
  }

  // Crea un nuevo articulo en la tabla articulo.
  public void create(Articulo entity) throws Exception {
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

  // Lee un articulo desde la tabla articulo
  public Articulo read(int id) throws Exception {
    EntityManager em = emf.createEntityManager();
    Articulo alu = em.find(Articulo.class, id);
    return alu;
  }

  // Utilizando Dynamic Query
  public List<Articulo> readAll1() throws Exception {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("select a from Articulo a");
    List<Articulo> lista = query.getResultList();
    return lista;
  }

  // Utilizando Named Query
  public List<Articulo> readAll2() throws Exception {
    EntityManager em = emf.createEntityManager();
    Query query = em.createNamedQuery("Articulo.findAll");
    List<Articulo> lista = query.getResultList();
    return lista;
  }
  
  // Consulta con parámetros
  public List<Articulo> readForName(String name) throws Exception {
    EntityManager em = emf.createEntityManager();
    String sql = "select a from Articulo a "
            + "where a.nombre like :name";
    Query query = em.createQuery(sql);
    query.setParameter("name", name + "%");
    List<Articulo> lista = query.getResultList();
    return lista;
  }

  // Actualiza los datos de un articulo
  public void update(Articulo entity) throws Exception {
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

  // Elimina un articulo de la tabla
  public void delete(Integer id) throws Exception {
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    try {
      entr.begin();
      Articulo articulo = em.find(Articulo.class, id);
      em.remove(articulo);
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
