package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Provincia;

public interface ProvinciaDAO {
	
	public List<Provincia> findByPaisIdioma (Connection connection, String codPais, String codIdioma)
			throws DataException;
	
	public List<Provincia> findAll(Connection connection, String codIdioma,
		 	int startIndex, int count) 
	throws DataException;

}

