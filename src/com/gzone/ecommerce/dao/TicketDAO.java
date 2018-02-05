/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Ticket;
import com.gzone.ecommerce.service.TicketCriteria;

/**
 * @author hector.ledo.doval
 *
 */
public interface TicketDAO {
	
	public Ticket findById(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;
	
    public List<Ticket> findByCriteria(Connection connection, TicketCriteria ticket, int startIndex, int count)
        	throws DataException;
    
    public List<Ticket> findAll(Connection connection,int startIndex, int count) 
        	throws DataException;
         
	public Boolean exists(Connection connection, Long id) 
    		throws DataException;

	public long countAll(Connection connection) 
     		throws DataException;   
     
    public Ticket create(Connection connection, Ticket ticket) 
    		throws DuplicateInstanceException, DataException;

    public void update(Connection connection, Ticket ticket) 
    		throws InstanceNotFoundException, DataException;
        
    public long delete(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;

}
