/**
 * 
 */
package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gzone.ecommerce.dao.NJugadoresDAO;
import com.gzone.ecommerce.dao.impl.NJugadoresDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.NJugadores;
import com.gzone.ecommerce.service.NJugadoresService;

/**
 * @author usuario
 *
 */
public class NJugadoresServiceImpl implements NJugadoresService{
	
	private NJugadoresDAO dao = null;
	
	public NJugadoresServiceImpl() {
		dao = new NJugadoresDAOImpl();
	}
	
	public NJugadores findById(Long id) 
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

	public List<NJugadores> findAll(int startIndex, int count) 
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
	
	public List<NJugadores> findByProducto(Long idProducto,int startIndex, int count)  
			throws DataException {
				
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.findByProducto(connection,idProducto,startIndex,count);		
			
		} catch (SQLException e){
			throw new DataException(e);
		} finally {
			JDBCUtils.closeConnection(connection);
		}		
	}
}

