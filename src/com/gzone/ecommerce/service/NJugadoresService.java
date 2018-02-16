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

	public Boolean exists(Long id) 
			throws DataException;

	public List<NJugadores> findAll(int startIndex, int count) 
			throws DataException;

	public long countAll() 
			throws DataException;
}
