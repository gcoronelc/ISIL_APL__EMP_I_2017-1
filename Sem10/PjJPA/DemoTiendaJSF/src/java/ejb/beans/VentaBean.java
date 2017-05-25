package ejb.beans;

import ejb.entity.Articulo;
import ejb.entity.Cliente;
import ejb.entity.Detalle;
import ejb.entity.Venta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import jsf.VentaItem;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN) // indispensable
public class VentaBean implements VentaBeanLocal {

	@PersistenceContext(unitName = "TiendaPU")
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	@Override
	public List<Cliente> getListaClientes() throws Exception {
		Query query = em.createQuery("select c from Cliente c");
		List<Cliente> lista = query.getResultList();
		return lista;
	}

	@Override
	public List<Articulo> getListaArticulos() throws Exception {
		Query query = em.createQuery("select a from Articulo a");
		List<Articulo> lista = query.getResultList();
		return lista;
	}

	@Override
	public Articulo consultaArticulo(Long id) throws Exception {
		Articulo a = em.find(Articulo.class, id);
		return a;
	}

	@Override
	public void procesarVenta(Long cliId, List<VentaItem> items) throws Exception {
		Double total = 0.0, subtotal = 0.0, impuesto = 0.0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Calculos Previos
		for (VentaItem vi : items) {
			total += vi.getImporte();
		}
		subtotal = total / 1.18;
		impuesto = total - subtotal;
		// Proceso
		try {
			// Obtener la fecha del sistema
			Query q = em.createNativeQuery("select sysdate() as fecha");
			String fecha = q.getSingleResult().toString();
			System.out.println("Fecha: " + fecha);
			// Preparar el registro de venta
			Venta venta = new Venta();
			Cliente c = consultarCliente(cliId);
			venta.setCliente(c);
			venta.setTotal(total);
			venta.setSubtotal(subtotal);
			venta.setImpuesto(impuesto);
			venta.setFecha(dateFormat.parse(fecha));
			// grabar venta
			utx.begin();
			em.persist(venta);
			for (VentaItem vi : items) {
				Detalle d = new Detalle();
				Articulo a = consultaArticulo(vi.getId());
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
			utx.commit();
		} catch (Exception e) {
			utx.rollback();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Cliente consultarCliente(Long id) throws Exception {
		Cliente c = em.find(Cliente.class, id);
		return c;
	}

	@Override
	public List consultarVentas() throws Exception {
		String q = "SELECT a.nombre, sum(d.cantidad) as cant "
				  + "FROM Articulo a, Detalle d "
				  + "WHERE a = d.articulo "
				  + "GROUP BY a";
		Query query = em.createQuery(q);
		List lista = query.getResultList();
		return lista;
	}
}
