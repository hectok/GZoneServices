package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gzone.ecommerce.dao.CategoriaDAO;
import com.gzone.ecommerce.dao.impl.CategoriaDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Categoria;
import com.gzone.ecommerce.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDAO dao = null;
	
	public CategoriaServiceImpl() {
		dao = new CategoriaDAOImpl();
	}
	
	public Categoria findById(Long id) 
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

	public List<Categoria> findAll(int startIndex, int count, String idioma) 
			throws DataException {
			
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.findAll(connection, startIndex, count, idioma);	
			
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

	public List<Categoria> findByProducto(Long id,int startIndex, int count, String idioma) 
			throws DataException {
				
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.findByProducto(connection, id,startIndex, count,idioma);	
			
		} catch (SQLException e){
			throw new DataException(e);
		} finally {
			JDBCUtils.closeConnection(connection);
		}
		
	}

}
