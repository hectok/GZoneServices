/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.LineaTicket;
import com.gzone.ecommerce.model.LineaTicketId;


/**
 * @author hector.ledo.doval
 *
 */
public interface LineaTicketDAO {
	
	public LineaTicket findById(Connection connection, LineaTicketId id) 
        	throws DataException;
	
	public Boolean exists(Connection connection, LineaTicketId id) 
    		throws DataException;
	    
    public List<LineaTicket> findByTicket(Connection connection, Long idTicket) 
        	throws DataException;
  
    public LineaTicket create(Connection connection, LineaTicket c) 
    		throws DuplicateInstanceException, DataException;
        
    public long delete(Connection connection, LineaTicketId id) 
    		throws InstanceNotFoundException, DataException;

}