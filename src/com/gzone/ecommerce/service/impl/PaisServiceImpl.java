package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gzone.ecommerce.dao.PaisDAO;
import com.gzone.ecommerce.dao.impl.PaisDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Pais;
import com.gzone.ecommerce.service.PaisService;

public class PaisServiceImpl implements PaisService {
	
	private PaisDAO paisDao = null;
	
	public PaisServiceImpl() {
		paisDao = new PaisDAOImpl();
	}
	
	public List<Pais> findByIdioma(String idiomaId)
			throws DataException{
		
		Connection connection = null;
		
		try {
			
			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);
			
			return paisDao.findByIdioma(connection, idiomaId);
			
		} catch (SQLException e){
			throw new DataException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DataException(e);
				}
			}
		}
		
	}

}
