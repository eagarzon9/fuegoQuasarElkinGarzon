package com.solucionOperaQuasar.utilities;

public class ExceptionRestUtil extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExceptionRestUtil(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionRestUtil(String message) {
		super(message);
	}

}
