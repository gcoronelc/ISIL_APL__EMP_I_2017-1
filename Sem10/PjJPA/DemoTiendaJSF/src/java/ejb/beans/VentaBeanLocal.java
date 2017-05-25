
package ejb.beans;

import ejb.entity.Articulo;
import ejb.entity.Cliente;
import java.util.List;
import javax.ejb.Local;
import jsf.VentaItem;

@Local
public interface VentaBeanLocal {

	List<Cliente> getListaClientes() throws Exception;
	List<Articulo> getListaArticulos() throws Exception;
	Articulo consultaArticulo(Long id) throws Exception;
	void procesarVenta(Long cliId, List<VentaItem> items) throws Exception;
	Cliente consultarCliente(Long id) throws Exception;
	List consultarVentas() throws Exception;
}
