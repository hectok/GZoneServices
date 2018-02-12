/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Oferta;

/**
 * @author hector.ledo.doval
 *
 */
public interface OfertaService {
	
	public Oferta findById(Long id) 
    		throws InstanceNotFoundException, DataException;
	
	public List<Oferta> findByCriteria(OfertaCriteria Oferta, int startIndex, int count)
	   	    throws InstanceNotFoundException,DataException;
	
    public Boolean exists(Long id) 
    		throws DataException;

    public List<Oferta> findAll(int startIndex, int count) 
    		 throws DataException;
     
    public long countAll() 
     		throws DataException;          
    
    public Oferta create(Oferta o) 
    		throws DuplicateInstanceException, DataException;

    public void update(Oferta o) 
    		throws InstanceNotFoundException, DataException;
        
    public long delete(Long id) 
    		throws InstanceNotFoundException, DataException;
}
