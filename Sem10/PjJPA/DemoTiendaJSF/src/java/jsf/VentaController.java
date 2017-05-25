package jsf;

import ejb.beans.VentaBeanLocal;
import ejb.entity.Articulo;
import ejb.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class VentaController {

	@EJB
	private VentaBeanLocal ventaBean;
	private Long cliId;
	private List<SelectItem> listaClientes = null;
	private Long artId;
	private List<SelectItem> listaArticulos = null;
	private Long cantidad;
	private List<VentaItem> listaItems;
	private String mensaje;
	private Long cantArticulos;
	private Double importeTotal;

	public VentaController() {
		this.cantArticulos = 0L;
		this.importeTotal = 0.0;
		crearListaItems();
	}

	public Long getCliId() {
		return cliId;
	}

	public void setCliId(Long cliId) {
		this.cliId = cliId;
	}

	public List<SelectItem> getListaClientes() {
		if (this.listaClientes == null) {
			this.cargarClientes();
		}
		return listaClientes;
	}

	public Long getArtId() {
		return artId;
	}

	public void setArtId(Long artId) {
		this.artId = artId;
	}

	public List<SelectItem> getListaArticulos() {
		if (this.listaArticulos == null) {
			this.cargarArticulos();
		}
		return listaArticulos;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public List<VentaItem> getListaItems() {
		return listaItems;
	}

	private void cargarClientes() {
		listaClientes = new ArrayList<SelectItem>();
		this.mensaje = "";
		try {
			List<Cliente> lista2 = ventaBean.getListaClientes();
			for (Cliente c : lista2) {
				SelectItem i = new SelectItem(c.getId(), c.getNombre());
				this.listaClientes.add(i);
			}
		} catch (Exception e) {
			this.mensaje = e.getMessage();
		}
	}

	private void cargarArticulos() {
		listaArticulos = new ArrayList<SelectItem>();
		this.mensaje = "";
		try {
			List<Articulo> lista2 = ventaBean.getListaArticulos();
			for (Articulo a : lista2) {
				SelectItem i = new SelectItem(a.getId(), a.getNombre());
				this.listaArticulos.add(i);
			}
		} catch (Exception e) {
			this.mensaje = e.getMessage();
		}
	}

	private void crearListaItems() {
		listaItems = new ArrayList<VentaItem>();
	}

	public String getMensaje() {
		return mensaje;
	}

	public Long getCantArticulos() {
		return cantArticulos;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	private void calcularTotales() {
		cantArticulos = 0L;
		importeTotal = 0.0;
		for (VentaItem i : listaItems) {
			cantArticulos = cantArticulos + i.getCantidad();
			importeTotal = importeTotal + i.getImporte();
		}
	}

	public String agregarItem() {
		this.mensaje = "";
		try {
			// Consultando el artículo
			Articulo a = ventaBean.consultaArticulo(this.artId);
			// buscando el articulo en la lista
			boolean encontro = false;
			for (VentaItem vi : this.listaItems) {
				if (vi.getId() == a.getId()) {
					encontro = true;
					vi.setCantidad(vi.getCantidad() + this.cantidad);
					if (vi.getCantidad() <= 0) {
						this.listaItems.remove(vi);
					}
					break;
				}
			}
			// Si no lo encuentra hay que agregarlo
			if (!encontro) {
				VentaItem i = new VentaItem();
				i.setId(a.getId());
				i.setNombre(a.getNombre());
				i.setPrecio(a.getPrecio());
				i.setCantidad(this.cantidad);
				this.listaItems.add(i);
			}
			// Calcular totales
			this.calcularTotales();
		} catch (Exception e) {
			this.mensaje = e.getMessage();
		}
		return "ventas";
	}

	public String procesarVenta() {
		mensaje = "";
		try {
			ventaBean.procesarVenta(cliId, listaItems);
			this.listaItems.clear();
			this.calcularTotales();
			mensaje = "Proceso ejecutado satisfactoriamente.";
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		return "ventas";
	}
}
