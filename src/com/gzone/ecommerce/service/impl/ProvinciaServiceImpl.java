package com.gzone.ecommerce.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gzone.ecommerce.dao.ProvinciaDAO;
import com.gzone.ecommerce.dao.impl.ProvinciaDAOImpl;
import com.gzone.ecommerce.dao.util.ConnectionManager;
import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Provincia;
import com.gzone.ecommerce.service.ProvinciaService;

public class ProvinciaServiceImpl implements ProvinciaService{

	private ProvinciaDAO provinciaDao = null;

	public ProvinciaServiceImpl() {
		provinciaDao = new ProvinciaDAOImpl();
	}

	public List<Provincia> findByPaisIdioma (String codPais, String codIdioma)
			throws DataException{
		Connection connection = null;

		try {

			connection = ConnectionManager.getConnection();
			connection.setAutoCommit(true);

			return provinciaDao.findByPaisIdioma(connection, codPais, codIdioma);

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

