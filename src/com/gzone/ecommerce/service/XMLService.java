/**
 * 
 */
package com.gzone.ecommerce.service;

import java.io.IOException;
import java.util.List;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.InstanceNotFoundException;
import com.gzone.ecommerce.model.Hotel;

/**
 * @author hector.ledo.doval
 * Servicio para el tratamineto de un XML recibido tras una petición a los servicios Web de Hotusa
 */
public interface XMLService {
	
	public List<Hotel> XMLRequest() 
    		throws InstanceNotFoundException, DataException, IOException;

}
