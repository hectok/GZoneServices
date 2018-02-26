/**
 * 
 */
package com.gzone.ecommerce.model;

/**
 * @author hector.ledo.doval
 *
 */
public class Categoria {

	private Long idCategoria = null;
	private String categoria = null;
	
	public Categoria () {}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
