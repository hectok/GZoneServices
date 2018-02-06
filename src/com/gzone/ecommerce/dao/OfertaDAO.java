/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Oferta;
import com.gzone.ecommerce.service.OfertaCriteria;



/**
 * @author Hector
 *
 */
public interface OfertaDAO {
	
	public Oferta findById(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;

	public Boolean exists(Connection connection, Long id) 
    		throws DataException;

    public List<Oferta> findAll(Connection connection,int startIndex, int count) 
    	throws DataException;
    
    public long countAll(Connection connection) 
     		throws DataException;   
     
    public List<Oferta> findByCriteria(Connection connection, OfertaCriteria oc, int startIndex, int count)
    	throws DataException;
    
    public Oferta create(Connection connection, Oferta o) 
    		throws DuplicateInstanceException, DataException;

    public void update(Connection connection, Oferta o) 
    		throws InstanceNotFoundException, DataException;
        
    public long delete(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;
}
