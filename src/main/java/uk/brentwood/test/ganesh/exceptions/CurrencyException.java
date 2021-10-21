package uk.brentwood.test.ganesh.exceptions;

public class CurrencyException extends RuntimeException{

	public CurrencyException(String message, Throwable cause) {
		super(message, cause);
	}

	public CurrencyException(String message) {
		super(message);
	}

	public CurrencyException(Throwable cause) {
		super(cause);
	}
	
	

	
}
