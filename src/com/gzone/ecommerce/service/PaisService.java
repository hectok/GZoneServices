package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Pais;

public interface PaisService {
	
	public List<Pais> findByIdioma(String idiomaId)
			throws DataException;

}
