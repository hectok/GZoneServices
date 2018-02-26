/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.NJugadores;

/**
 * @author hector.ledo.doval
 *
 */
public interface NJugadoresService {
	
	public NJugadores findById(Long id) 
			throws InstanceNotFoundException, DataException;

	public List<NJugadores> findByProducto(Long idProducto,int startIndex, int count) 
			throws DataException;
	
}
