/**
 * 
 */
package com.gzone.ecommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author hector.ledo.doval
 *
 */
public class Ticket {

	private Long codCompra = null;
	private Long cantidad = null;
	private Date fechaTicket = null;
	private String dirFacturacion = null;
	private Long id_usuario = null;

	
	private List<LineaTicket> lineas = null;
	
	public Ticket() {
		lineas = new ArrayList<LineaTicket>();
	}

	public Long getCodCompra() {
		return codCompra;
	}

	public void setCodCompra(Long codCompra) {
		this.codCompra = codCompra;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaTicket() {
		return fechaTicket;
	}

	public void setFechaTicket(Date fechaTicket) {
		this.fechaTicket = fechaTicket;
	}

	public String getDirFacturacion() {
		return dirFacturacion;
	}

	public void setDirFacturacion(String dirFacturacion) {
		this.dirFacturacion = dirFacturacion;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public List<LineaTicket> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaTicket> lineas) {
		this.lineas = lineas;
	}
	
	
}
