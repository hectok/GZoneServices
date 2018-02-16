package com.gzone.ecommerce.dao;

/**
 * 
 */

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Categoria;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;

/**
 * @author Hector
 *
 */
public interface CategoriaDAO {
	
	public Categoria findById(Connection connection, Long id) 
			throws InstanceNotFoundException, DataException;
	
	public Boolean exists(Connection connection, Long id) 
    		throws DataException;

    public List<Categoria> findAll(Connection connection,int startIndex, int count) 
    	throws DataException;
    
    public long countAll(Connection connection) 
     		throws DataException;   
     
    public List<Categoria> findByProducto(Connection connection, Long idProducto) 
        	throws DataException;

}