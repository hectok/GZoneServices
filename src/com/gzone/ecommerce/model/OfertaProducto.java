/**
 * 
 */
package com.gzone.ecommerce.model;

/**
 * @author hector.ledo.doval
 *
 */
public class OfertaProducto {
	
	private Long idProducto = null;
	private Long idOferta = null;
	private Long cantidad = null;
	private Double precio = null;
	
	public OfertaProducto () {}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
