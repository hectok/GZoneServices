/**
 * 
 */
package com.gzone.ecommerce.service.impl;

import com.gzone.ecommerce.exceptions.DataException;
import com.gzone.ecommerce.exceptions.ServiceException;
import com.gzone.ecommerce.model.Tarjeta;
import com.gzone.ecommerce.service.BankService;

/**
 * @author hector.ledo.doval
 *
 */
public class MockBankService implements BankService{
	
	private Tarjeta recibirTarjeta = null;

	public MockBankService() {		
	}

	@Override
	public boolean checkCard(Tarjeta tarjeta) 
			throws DataException, ServiceException {
		Boolean salida = false;
		
		recibirTarjeta = new Tarjeta();
				
		if (comprobarNumero(tarjeta.getNumero())) {
			salida=true;
			recibirTarjeta.setNumero(tarjeta.getNumero());		
			recibirTarjeta.setTitular(tarjeta.getTitular());
			recibirTarjeta.setCaducidad(tarjeta.getCaducidad());
			recibirTarjeta.setCcv(tarjeta.getCcv());
		}		
		return salida;
	}
	
    protected static boolean comprobarNumero(String numeroTarjeta) {
        int digits = numeroTarjeta.length();
        int oddOrEven = digits & 1;
        long sum = 0;
        for (int count = 0; count < digits; count++) {
            int digit = 0;
            try {
                digit = Integer.parseInt(numeroTarjeta.charAt(count) + "");
            } catch(NumberFormatException e) {
                return false;
            }

            if (((count & 1) ^ oddOrEven) == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }

        return (sum == 0) ? false : (sum % 10 == 0);
    }
}
