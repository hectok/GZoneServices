/**
 * 
 */
package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gzone.ecommerce.dao.TicketDAO;
import com.gzone.ecommerce.dao.impl.TicketDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Ticket;
import com.gzone.ecommerce.service.TicketCriteria;
import com.gzone.ecommerce.service.TicketService;

/**
 * @author hector.ledo.doval
 *
 */
public class TicketServiceImpl implements TicketService{

		private TicketDAO dao = null;
		
		public TicketServiceImpl() {
			dao = new TicketDAOImpl();
		}
		
		public Ticket findById(Long id) 
				throws InstanceNotFoundException, DataException {
					
			Connection connection = null;
			
			try {
				
				connection = ConnectionManager.getConnection();
				connection.setAutoCommit(true);
				
				return dao.findById(connection, id);	
				
			} catch (SQLException e){
				throw new DataException(e);
			} finally {
				JDBCUtils.closeConnection(connection);
			}
			
		}
		
		public List<Ticket> findAll(int startIndex, int count) 
				throws DataException {
				
			Connection connection = null;
			
			try {
				
				connection = ConnectionManager.getConnection();
				connection.setAutoCommit(true);
				
				return dao.findAll(connection, startIndex, count);	
				
			} catch (SQLException e){
				throw new DataException(e);
			} finally {
				JDBCUtils.closeConnection(connection);
			}
			
		}
		
		public Boolean exists(Long id) 
				throws DataException {
					
			Connection connection = null;
			
			try {
				
				connection = ConnectionManager.getConnection();
				connection.setAutoCommit(true);
				
				return dao.exists(connection, id);
				
			} catch (SQLException e){
				throw new DataException(e);
			} finally {
				JDBCUtils.closeConnection(connection);
			}
			
		}

		public long countAll() 
				throws DataException {
					
			Connection connection = null;
			
			try {
				
				connection = ConnectionManager.getConnection();
				connection.setAutoCommit(true);
				
				return dao.countAll(connection);		
				
			} catch (SQLException e){
				throw new DataException(e);
			} finally {
				JDBCUtils.closeConnection(connection);
			}
			
		}
		
	     public List<Ticket> findByCriteria(TicketCriteria ticket, int startIndex, int count)
				throws DataException {
				
			Connection connection = null;
			
			try {
				
				connection = ConnectionManager.getConnection();
				connection.setAutoCommit(true);
				
				return dao.findByCriteria(connection, ticket, startIndex, count);
				
			} catch (SQLException e){
				throw new DataException(e);
			} finally {
				JDBCUtils.closeConnection(connection);
			}
		}

		public Ticket create(Ticket t) 
				throws DuplicateInstanceException, DataException {
			
		    Connection connection = null;
	        boolean commit = false;

	        try {
	          
	            connection = ConnectionManager.getConnection();

	            connection.setTransactionIsolation(
	                    Connection.TRANSACTION_READ_COMMITTED);

	            connection.setAutoCommit(false);

	            // Execute action
	            Ticket result = dao.create(connection, t);
	            commit = true;
	            
	            return result;

	        } catch (SQLException e) {
	            throw new DataException(e);

	        } finally {
	        	JDBCUtils.closeConnection(connection, commit);
	        }		
		}

		public void update(Ticket t) 
				throws InstanceNotFoundException, DataException {
			
		    Connection connection = null;
	        boolean commit = false;

	        try {
	          
	            connection = ConnectionManager.getConnection();

	            connection.setTransactionIsolation(
	                    Connection.TRANSACTION_READ_COMMITTED);

	            connection.setAutoCommit(false);

	            dao.update(connection,t);
	            commit = true;
	            
	        } catch (SQLException e) {
	            throw new DataException(e);

	        } finally {
	        	JDBCUtils.closeConnection(connection, commit);
	        }
		}

		public long delete(Long id) 
				throws InstanceNotFoundException, DataException {
			
		    Connection connection = null;
	        boolean commit = false;

	        try {
	          
	            connection = ConnectionManager.getConnection();

	            connection.setTransactionIsolation(
	                    Connection.TRANSACTION_READ_COMMITTED);

	            connection.setAutoCommit(false);

	            long result = dao.delete(connection, id);            
	            commit = true;            
	            return result;
	            
	        } catch (SQLException e) {
	            throw new DataException(e);

	        } finally {
	        	JDBCUtils.closeConnection(connection, commit);
	        }		
		}
	}


