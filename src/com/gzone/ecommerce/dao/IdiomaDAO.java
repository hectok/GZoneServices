/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Idioma;

/**
 * @author hector.ledo.doval
 *
 */
public interface IdiomaDAO {
	
	public Idioma findById(Connection connection, String id) 
    		throws InstanceNotFoundException, DataException;
	
	public List<Idioma> findByProducto(Connection connection, Long idProducto,int startIndex, int count) 
			throws DataException;

}
