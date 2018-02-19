package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Producto;

public interface ProductoService {
	
	    public List<Producto> findByCriteria(ProductoCriteria Producto, int startIndex, int count)
	   	    throws DataException;
	    
	    public List<Producto> findAll(int startIndex, int count) 
	    	throws DataException;  
	    
	    public Producto findById(Long id) 
	    	throws InstanceNotFoundException, DataException;

		public Boolean exists(Long id) 
		    throws DataException;

		public long countAll() 
	     	throws DataException;  

	    public Producto create(Producto p) 
	    	throws DuplicateInstanceException, DataException;

	    public void update(Producto p) 
	    	throws InstanceNotFoundException, DataException;
	        
	    public long delete(Long integer) 
	    	throws InstanceNotFoundException, DataException;
}
