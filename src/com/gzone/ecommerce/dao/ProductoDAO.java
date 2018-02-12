/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.ProductoCriteria;

/**
 * @author Hector
 *
 */
public interface ProductoDAO {
	
    public List<Producto> findByCriteria(Connection connection, ProductoCriteria producto, int startIndex, int count)
        	throws DataException;

    public List<Producto> findAll(Connection connection,int startIndex, int count) 
    	throws DataException;
     
	public Boolean exists(Connection connection, Long id) 
    		throws DataException;

	public long countAll(Connection connection) 
     		throws DataException;   
     
    public Producto create(Connection connection, Producto producto) 
    		throws DuplicateInstanceException, DataException;

    public void update(Connection connection, Producto producto) 
    		throws InstanceNotFoundException, DataException;
        
    public long delete(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;

}
