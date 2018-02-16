/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Categoria;

/**
 * @author Hector
 *
 */
public interface CategoriaService {
	
	public Categoria findById(Long id) 
			throws InstanceNotFoundException, DataException;

	public Boolean exists(Long id) 
			throws DataException;

	public List<Categoria> findAll(int startIndex, int count) 
			throws DataException;

	public long countAll() 
			throws DataException;

	public List<Categoria> findByCategoria(Long idProducto, int startIndex, int count) 
			throws DataException;

}
