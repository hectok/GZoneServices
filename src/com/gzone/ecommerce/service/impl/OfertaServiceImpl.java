/**
 * 
 */
package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gzone.ecommerce.dao.OfertaDAO;
import com.gzone.ecommerce.dao.impl.OfertaDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Oferta;
import com.gzone.ecommerce.service.OfertaService;
import com.gzone.ecommerce.service.OfertaCriteria;

/**
 * @author hector.ledo.doval
 *
 */
public class OfertaServiceImpl implements OfertaService{
	
	private OfertaDAO dao = null;
	
	public OfertaServiceImpl() {
		dao = new OfertaDAOImpl();
	}
	
	public Oferta findById(Long id) 
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
	
    public List<Oferta> findByCriteria(OfertaCriteria Oferta, int startIndex, int count)
    		throws InstanceNotFoundException, DataException {
			
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.findByCriteria(connection, Oferta, startIndex, count);
			
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

	public List<Oferta> findAll(int startIndex, int count) 
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

	public Oferta create(Oferta o) 
			throws DuplicateInstanceException, DataException {
		
	    Connection connection = null;
        boolean commit = false;

        try {

            // Get a connection with autocommit to "false" 
        	// and isolation level to "TRANSACTION_READ_COMMITTED"
          
            connection = ConnectionManager.getConnection();

            connection.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);

            connection.setAutoCommit(false);

            // Execute action
            Oferta result = dao.create(connection, o);
            commit = true;
            
            return result;

        } catch (SQLException e) {
            throw new DataException(e);
        } finally {
        	JDBCUtils.closeConnection(connection, commit);
        }		
	}

	public void update(Oferta o) 
			throws InstanceNotFoundException, DataException {
		
	    Connection connection = null;
        boolean commit = false;

        try {
          
            connection = ConnectionManager.getConnection();

            connection.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);

            connection.setAutoCommit(false);

            // Execute action
            dao.update(connection,o);
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

            // Execute action
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

