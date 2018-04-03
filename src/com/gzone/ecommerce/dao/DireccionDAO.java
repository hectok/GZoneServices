package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Direccion;

public interface DireccionDAO {
	
	public Direccion findById(Connection connection, Long id)
		throws InstanceNotFoundException, DataException;
	
	public List<Direccion> findByIdUsuario (Connection connection, Long id)
		throws DataException;
	
	public Direccion create(Connection connection, Direccion d) 
 		throws DuplicateInstanceException, DataException;
	
	public void update (Connection connection, Direccion d)
		throws InstanceNotFoundException, DataException;
	
	public long delete(Connection connection, Long id)
		throws DataException;
     
}
