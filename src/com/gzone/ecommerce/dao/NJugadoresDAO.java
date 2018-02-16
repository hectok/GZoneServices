/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.NJugadores;

/**
 * @author hector.ledo.doval
 *
 */
public interface NJugadoresDAO {
	
	public NJugadores findById(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;
	
    public List<NJugadores> findAll(Connection connection,int startIndex, int count) 
    	throws DataException;
     
	public Boolean exists(Connection connection, Long id) 
    		throws DataException;

	public long countAll(Connection connection) 
     		throws DataException;  
}
