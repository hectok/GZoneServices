/**
 * 
 */
package com.gzone.ecommerce.service;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.ServiceException;
import com.gzone.ecommerce.model.Tarjeta;

/**
 * @author hector.ledo.doval
 *
 */
public interface BankService {
	
	public boolean checkCard(Tarjeta tarjeta)
			throws DataException, ServiceException;
}
