package io.openbdt.exception;

public class ValidationException extends RuntimeException {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -4740821977926909310L;

	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public ValidationException(final String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public ValidationException(final Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message	- String
	 * @param cause 	- Throwable
	 */
	public ValidationException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
