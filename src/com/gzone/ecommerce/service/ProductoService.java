package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Producto;

public interface ProductoService {
	
		public Producto findById(Integer integer) 
	   		throws InstanceNotFoundException, DataException;

	    public List<Producto> findByCriteria(ProductoCriteria Producto, int startIndex, int count)
	   	    throws DataException;
	    
	    public List<Producto> findAll(int startIndex, int count) 
	    	throws DataException;  
	    
		public Boolean exists(Integer id) 
		    throws DataException;

		public long countAll() 
	     	throws DataException;  

	    public Producto create(Producto p) 
	    	throws DuplicateInstanceException, DataException;

	    public void update(Producto p) 
	    	throws InstanceNotFoundException, DataException;
	        
	    public long delete(Integer integer) 
	    	throws InstanceNotFoundException, DataException;
}
