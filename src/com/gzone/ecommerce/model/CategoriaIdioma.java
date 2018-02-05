/**
 * 
 */
package com.gzone.ecommerce.model;

/**
 * @author hector.ledo.doval
 *
 */
public class CategoriaIdioma {
	
	private Long idCategoria = null;
	private String idIdioma = null;
	private String nombreCategoria =null;
	
	public CategoriaIdioma () {}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(String idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
}
