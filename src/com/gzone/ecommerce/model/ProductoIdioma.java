/**
 * 
 */
package com.gzone.ecommerce.model;

/**
 * @author hector.ledo.doval
 *
 */
public class ProductoIdioma {
	
	private Long idProducto = null;
	private String idIdioma = null;
	private String detallesL = null;
	private String detallesC = null;

	public ProductoIdioma() {}

	
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(String idIdioma) {
		this.idIdioma = idIdioma;
	}

	public String getDetallesL() {
		return detallesL;
	}

	public void setDetallesL(String detallesL) {
		this.detallesL = detallesL;
	}

	public String getDetallesC() {
		return detallesC;
	}

	public void setDetallesC(String detallesC) {
		this.detallesC = detallesC;
	}
	
	
}
