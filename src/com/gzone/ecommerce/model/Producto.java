/**
 * 
 */
package com.gzone.ecommerce.model;

/**
 * @author hector.ledo.doval
 *
 */
public class Producto {

	private Integer idProducto = null;
	private String nombre = null;
	private Double precio = null;
	private Integer anio = null;
	private String requisitos = null;
	private Long oferta = null;
	
	public Producto () {}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer i) {
		this.anio = i;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public Long getOferta() {
		return oferta;
	}

	public void setOferta(Long oferta) {
		this.oferta = oferta;
	}
	
	
}
