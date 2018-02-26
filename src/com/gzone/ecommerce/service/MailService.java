package com.gzone.ecommerce.service;

import com.gzone.ecommerce.exceptions.MailException;

public interface MailService {
	
	public void sendMail(String subject, String message, String... to)
		throws MailException;

}
