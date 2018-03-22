/**
 * 
 */
package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gzone.ecommerce.dao.IdiomaDAO;
import com.gzone.ecommerce.dao.impl.IdiomaDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Idioma;
import com.gzone.ecommerce.service.IdiomaService;


/**
 * @author hector.ledo.doval
 *
 */
public class IdiomaServiceImpl implements IdiomaService{
	
	private IdiomaDAO dao = null;
	
	public IdiomaServiceImpl() {
		dao = new IdiomaDAOImpl();
	}
	
	public Idioma findById(String id) 
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
	
	public List<Idioma> findAll(int startIndex, int count) 
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
	
	public List<Idioma> findByProducto(Long idProducto,int startIndex, int count) 
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

