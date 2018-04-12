package com.gzone.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class MyCompanyException extends Exception {
	
	private String errorException = null;
	
	public MyCompanyException() {
		super();
	}
	
	public MyCompanyException(String message) {
		this(message, null);		
	}
	
	public MyCompanyException(Throwable cause) {
		this(null,cause);		
	}
	
	public MyCompanyException(String message, Throwable cause) {
		super(cause);
		this.errorException=message;
	}			
	
	public void printStackTrace() {
		if (getCause()!=null) {
			getCause().printStackTrace();
		} else {
			super.printStackTrace();
		}
	}
	

	public void printStackTrace(PrintStream s) {
		if (getCause()!=null) {
			getCause().printStackTrace(s);
		} else {
			super.printStackTrace(s);
		}
	}	
	
	public void printStackTrace(PrintWriter w) {
		if (getCause()!=null) {
			getCause().printStackTrace(w);
		} else {
			super.printStackTrace(w);
		}
	}

	public String getErrorException() {
		return errorException;
	}

	public void setErrorException(String errorException) {
		this.errorException = errorException;
	}	

}
