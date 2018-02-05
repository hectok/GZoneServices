/**
 * 
 */
package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Ticket;

/**
 * @author hector.ledo.doval
 *
 */
public interface TicketService {
	
		public Ticket findById(Long id) 
	   		throws InstanceNotFoundException, DataException;
		 
	    public List<Ticket> findByCriteria(TicketCriteria ticket, int startIndex, int count)
	   	    throws DataException;
	    
	    public List<Ticket> findAll(int startIndex, int count) 
	    	throws DataException;  
	    
		public Boolean exists(Long id) 
		    throws DataException;

		public long countAll() 
	     	throws DataException;  

	    public Ticket create(Ticket t) 
	    	throws DuplicateInstanceException, DataException;

	    public void update(Ticket t) 
	    	throws InstanceNotFoundException, DataException;
	        
	    public long delete(Long id) 
	    	throws InstanceNotFoundException, DataException;
}
