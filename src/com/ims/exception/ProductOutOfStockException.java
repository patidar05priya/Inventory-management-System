package com.ims.exception;

@SuppressWarnings("serial")
public class ProductOutOfStockException extends Exception{

	public ProductOutOfStockException() {
		super();
	}

	public ProductOutOfStockException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);	
	}

	public ProductOutOfStockException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductOutOfStockException(String message) {
		super(message);	
	}

	public ProductOutOfStockException(Throwable cause) {
		super(cause);
	}
	
}
