package com.gzone.ecommerce.model;
/**
 * @author hector.ledo.doval
 *
 */
public class LineaTicket {
	
	private Long idTicket = null;
	private Long idProducto = null;
	private Double precio = null;
	
	
	public LineaTicket() {
	}

	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
