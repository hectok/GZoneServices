/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Idioma;

/**
 * @author hector.ledo.doval
 *
 */
public interface IdiomaDAO {
	
	public Idioma findById(Connection connection, String id) 
    		throws InstanceNotFoundException, DataException;
	
    public List<Idioma> findAll(Connection connection,int startIndex, int count) 
    	throws DataException;
     
	public Boolean exists(Connection connection, String id) 
    		throws DataException;

	public long countAll(Connection connection) 
     		throws DataException;   
     
    public Idioma create(Connection connection, Idioma idioma) 
    		throws DuplicateInstanceException, DataException;

    public void update(Connection connection, Idioma idioma) 
    		throws InstanceNotFoundException, DataException;
        
    public long delete(Connection connection, String id) 
    		throws InstanceNotFoundException, DataException;
}
