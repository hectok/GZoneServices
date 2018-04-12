package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.model.Producto;
import com.gzone.exceptions.MyCompanyException;

public interface ProductoService {
	
	    public List<Producto> findByCriteria(ProductoCriteria Producto, int startIndex, int count, String idioma)
	    	throws MyCompanyException ;
	    
	    public List<Producto> findAll(int startIndex, int count, String idioma) 
	    	throws MyCompanyException ; 
	    
	    public Producto findById(Long id, String idioma) 
	    	throws MyCompanyException ;

		public long countAll() 
			throws MyCompanyException ;

}
