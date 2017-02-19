package com.ims.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{

	
	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}

	
	
}
