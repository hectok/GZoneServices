/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.OfertaProducto;
import com.gzone.ecommerce.model.OfertaProductoID;



/**
 * @author hector.ledo.doval
 *
 */
public interface OfertaProductoDAO {
	
	public OfertaProducto findById(Connection connection, OfertaProductoID id) 
        	throws DataException;
	
	public Boolean exists(Connection connection, OfertaProductoID id) 
    		throws DataException;
	    
    public List<OfertaProducto> findByOferta(Connection connection, Long idOp) 
        	throws DataException;
  
    public OfertaProducto create(Connection connection, OfertaProducto op) 
    		throws DuplicateInstanceException, DataException;
        
    public long delete(Connection connection, OfertaProductoID id) 
    		throws InstanceNotFoundException, DataException;
}
