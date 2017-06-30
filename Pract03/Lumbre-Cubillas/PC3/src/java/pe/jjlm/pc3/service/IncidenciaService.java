package pe.jjlm.pc3.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pe.jjlm.pc3.domain.Incidencia;
import pe.jjlm.pc3.model.IncidenciaModel;

public class IncidenciaService {

  private EntityManagerFactory emf;

  public IncidenciaService() {
    emf = Persistence.createEntityManagerFactory("PC3PU");
  }

  public List<Incidencia> getListaLocalTipo(String local, String tipo) {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("select c from Incidencia c where c.local = :local and c.tipo = :tipo");
    query.setParameter("local", local);
    query.setParameter("tipo", tipo);
    List<Incidencia> lista = query.getResultList();
    em.close();
    return lista;
  }

  public List<Incidencia> getListaLocalGravedad(String local, String gravedad) {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("select c from Incidencia c where c.local = :local and c.gravedad = :gravedad");
    query.setParameter("local", local);
    query.setParameter("gravedad", gravedad);
    List<Incidencia> lista = query.getResultList();
    em.close();
    return lista;
  }

  public void registrarIncidencia(Long id, IncidenciaModel inc) {
    EntityManager em = null;
    EntityTransaction entr = null;
    try{
      em = emf.createEntityManager();
      entr = em.getTransaction();
      //Obtener fecha actual
      Query f = em.createNativeQuery("select DATE_FORMAT(now(),'%Y/%m/%d') as fecha");
      String fecha = f.getSingleResult().toString();
      //Obtener hora actual
      Query h = em.createNativeQuery("select DATE_FORMAT(now(),'%H:%i:%s') as hora");
      String hora = h.getSingleResult().toString();
      
      Incidencia incidencia = new Incidencia();
      incidencia.setLocal(inc.getLocal());
      incidencia.setTipo(inc.getTipo());
      incidencia.setGravedad(inc.getGravedad());
      incidencia.setDescripcion(inc.getDescripcion());              
      incidencia.setFecha(fecha);
      incidencia.setHora(hora);
      incidencia.setRecomendacion(inc.getRecomendacion());
      
      entr.begin();
      em.persist(incidencia);
      entr.commit();
      
    }catch (Exception e) {
      entr.rollback();
      throw new RuntimeException(e.getMessage());
    }
  }
}
