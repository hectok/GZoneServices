package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Idioma;

/**
 * @author hector.ledo.doval
 *
 */
public interface IdiomaService {
		
		public Idioma findById(String id) 
				throws InstanceNotFoundException, DataException;

		public Boolean exists(String id) 
				throws DataException;

		public List<Idioma> findAll(int startIndex, int count) 
				throws DataException;

		public long countAll() 
				throws DataException;

}