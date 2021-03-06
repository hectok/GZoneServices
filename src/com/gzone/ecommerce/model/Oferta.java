/**
 * 
 */
package com.gzone.ecommerce.model;

import java.util.Date;

/**
 * @author hector.ledo.doval
 *
 */
public class Oferta {

	private Long idOferta = null;
	private Date fechaCreacion = null;
	private Double precio = null;
	
	public Oferta() {}

	public Long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
