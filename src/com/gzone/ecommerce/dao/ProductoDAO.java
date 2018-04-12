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
import com.gzone.exceptions.MyCompanyException;

/**
 * @author Hector
 *
 */
public interface ProductoDAO {
	
    public List<Producto> findByCriteria(Connection connection, ProductoCriteria producto, int startIndex, int count,String idioma)
    	throws MyCompanyException;

    public List<Producto> findAll(Connection connection,int startIndex, int count, String idioma) 
    	throws MyCompanyException;
	
	public Producto findById(Connection connection, Long id, String idioma) 
		throws MyCompanyException; 

	public long countAll(Connection connection) 
		throws MyCompanyException;	  

}
