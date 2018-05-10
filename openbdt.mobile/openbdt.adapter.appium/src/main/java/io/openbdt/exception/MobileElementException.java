package io.openbdt.exception;

public class MobileElementException extends RuntimeException {
	
	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public MobileElementException(String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public MobileElementException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message 	- String
	 * @param cause		- Throwable
	 */
	public MobileElementException(String message, Throwable cause) {
		super(message, cause);
	}
}
