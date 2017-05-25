package pe.egcc.venta.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.egcc.venta.domain.Articulo;
import pe.egcc.venta.domain.Cliente;
import pe.egcc.venta.domain.Detalle;
import pe.egcc.venta.domain.Venta;
import pe.egcc.venta.model.VentaItem;

public class VentaService {

  private EntityManagerFactory emf;

  public VentaService() {
    emf = Persistence.createEntityManagerFactory("VentaWebPU");
  }

  public List<Cliente> getListaClientes() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("select c from Cliente c");
    List<Cliente> lista = query.getResultList();
    em.close();
    return lista;
  }

  public List<Articulo> getListaArticulos() {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("select a from Articulo a");
    List<Articulo> lista = query.getResultList();
    em.close();
    return lista;
  }

  public Articulo getArticulo(Long id) {
    EntityManager em = emf.createEntityManager();
    Articulo a = em.find(Articulo.class, id);
    em.close();
    return a;
  }

  public void procesarVenta(Long cliId, List<VentaItem> items) {
    Double total = 0.0, subtotal = 0.0, impuesto = 0.0;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // Calculos Previos
    for (VentaItem vi : items) {
      total += vi.getImporte();
    }
    subtotal = total / 1.18;
    impuesto = total - subtotal;
    // Proceso
    EntityManager em = null;
    EntityTransaction entr = null;
    try {
      em = emf.createEntityManager();
      entr = em.getTransaction();
      // Obtener la fecha del sistema
      Query q = em.createNativeQuery("select sysdate() as fecha");
      String fecha = q.getSingleResult().toString();
      System.out.println("Fecha: " + fecha);
      // Preparar el registro de venta
      Venta venta = new Venta();
      Cliente c = em.find(Cliente.class, cliId);
      venta.setCliente(c);
      venta.setTotal(total);
      venta.setSubtotal(subtotal);
      venta.setImpuesto(impuesto);
      venta.setFecha(dateFormat.parse(fecha));
      // grabar venta
      entr.begin();
      em.persist(venta);
      for (VentaItem vi : items) {
        Detalle d = new Detalle();
        Articulo a = em.find(Articulo.class, vi.getId());
        d.setArticulo(a);
        d.setCantidad(vi.getCantidad());
        d.setPrecio(vi.getPrecio());
        d.setSubtotal(vi.getImporte());
        d.setVenta(venta);
        a.setStock(a.getStock() - vi.getCantidad());
        if (a.getStock() < 0) {
          throw new Exception("No existe stock sufuciente.");
        }
        em.merge(a);
        em.persist(d);
      }
      entr.commit();
    } catch (Exception e) {
      entr.rollback();
      throw new RuntimeException(e.getMessage());
    }
  }
}
