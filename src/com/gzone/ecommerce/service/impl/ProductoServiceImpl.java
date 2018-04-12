package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gzone.ecommerce.dao.ProductoDAO;
import com.gzone.ecommerce.dao.impl.ProductoDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.dao.util.JDBCUtils;
import com.gzone.ecommerce.model.Producto;
import com.gzone.ecommerce.service.ProductoCriteria;
import com.gzone.ecommerce.service.ProductoService;
import com.gzone.exceptions.ErrorExcepctions;
import com.gzone.exceptions.MyCompanyException;

public class ProductoServiceImpl implements ProductoService{
	
	private static Logger logger = LogManager.getLogger(ProductoServiceImpl.class.getName());
	
	private ProductoDAO dao = null;
	
	public ProductoServiceImpl() {
		dao = new ProductoDAOImpl();
	}

	public List<Producto> findAll(int startIndex, int count, String idioma) 
			throws MyCompanyException {
		
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.findAll(connection, startIndex, count, idioma);	
			
		} catch (SQLException e){
			logger.error(ErrorExcepctions.ERROR_DB,e);
			throw new MyCompanyException(ErrorExcepctions.ERROR_DB, e);
		} finally {
			JDBCUtils.closeConnection(connection);
		}
		
	}
	
	public long countAll() 
			throws MyCompanyException {
		
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.countAll(connection);		
			
		} catch (SQLException e){
			logger.error(ErrorExcepctions.ERROR_DB,e);
			throw new MyCompanyException(ErrorExcepctions.ERROR_DB, e);
		} finally {
			JDBCUtils.closeConnection(connection);
		}
		
	}
	
	public Producto findById(Long id, String idioma) 
			throws MyCompanyException {
		
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.findById(connection, id, idioma);	
			
		} catch (SQLException e){
			logger.error(ErrorExcepctions.ERROR_DB,e);
			throw new MyCompanyException(ErrorExcepctions.ERROR_DB, e);
		} finally {
			JDBCUtils.closeConnection(connection);
		}
		
	}
	
     public List<Producto> findByCriteria(ProductoCriteria Producto, int startIndex, int count, String idioma)
    		 throws MyCompanyException {
    	 
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return dao.findByCriteria(connection, Producto, startIndex, count, idioma);
			
		} catch (SQLException e){
			logger.error(ErrorExcepctions.ERROR_DB,e);
			throw new MyCompanyException(ErrorExcepctions.ERROR_DB, e);
		} finally {
			JDBCUtils.closeConnection(connection);
		}
	}

}

