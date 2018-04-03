package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.model.Provincia;

public interface ProvinciaService {
	
	public List<Provincia> findByPaisIdioma (String codPais, String codIdioma)
			throws DataException;

}
