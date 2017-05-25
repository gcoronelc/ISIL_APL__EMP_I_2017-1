
package pe.egcc.venta.model;

public class VentaItem {

	private Long id;
	private String nombre;
	private Double precio;
	private Long cantidad;

	public VentaItem() {
	}

	public VentaItem(Long id, String nombre, Double precio, Long cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getImporte(){
		Double importe = 0.0;
		importe = this.getPrecio() * this.getCantidad();
		return importe;
	}

}
