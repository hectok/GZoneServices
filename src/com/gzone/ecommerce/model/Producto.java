/**
 * 
 */
package com.gzone.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hector.ledo.doval
 *
 */
public class Producto {

	private Long idProducto = null;
	private String nombre = null;
	private Double precio = null;
	private Integer anio = null;
	private String requisitos = null;
	private Long oferta = null;
	
	private List<Categoria> categorias = null;
	private List<NJugadores> njugadores = null;

	public Producto () {
		categorias = new ArrayList<Categoria>();
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<NJugadores> getNjugadores() {
		return njugadores;
	}

	public void setNjugadores(List<NJugadores> njugadores) {
		this.njugadores = njugadores;
	}
	
	
}
