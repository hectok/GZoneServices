/**
 * 
 */
package com.gzone.ecommerce.dao;

import java.sql.Connection;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Usuario;
import com.gzone.ecommerce.service.UsuarioCriteria;


/**
 * @author Hector.ledo.doval
 *
 */
public interface UsuarioDAO {
	
	public Usuario findById(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;
	
    public List<Usuario> findByCriteria(Connection connection, UsuarioCriteria c, int startIndex, int count)
        	throws DataException;
    
    public Usuario findByNombre(Connection connection, String nombre)
    		throws DataException;
    
	public Boolean exists(Connection connection, Long id) 
    		throws DataException;

	public long countAll(Connection connection) 
     		throws DataException;   
     
    public Usuario create(Connection connection, Usuario user) 
    		throws DuplicateInstanceException, DataException;

    public void update(Connection connection, Usuario user) 
    		throws InstanceNotFoundException, DataException;
        
    public long delete(Connection connection, Long id) 
    		throws InstanceNotFoundException, DataException;

}
