package com.gzone.ecommerce.service;

import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.DuplicateInstanceException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.exceptions.MailException;
import com.gzone.ecommerce.model.Usuario;



public interface UsuarioService {

	public Usuario findById(Long id) 
   		throws InstanceNotFoundException, DataException;
	 
    public List<Usuario> findByCriteria(UsuarioCriteria Usuario, int startIndex, int count)
   	    throws DataException;
    
    public Usuario findByNombre(String Usuario)
       	    throws DataException;
    
	public Boolean exists(Long id) 
	    throws DataException;

	public long countAll() 
     	throws DataException;  

    public Usuario create(Usuario u) 
    	throws DuplicateInstanceException, DataException, MailException;

    public void update(Usuario u) 
    	throws InstanceNotFoundException, DataException;
        
    public long delete(Long id) 
    	throws InstanceNotFoundException, DataException;

}

