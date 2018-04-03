package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Pais;

public interface PaisDAO {
	
	public List<Pais> findByIdioma(Connection connection, String idiomaId)
	throws DataException;

}
