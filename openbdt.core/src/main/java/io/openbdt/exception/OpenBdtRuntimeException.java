package io.openbdt.exception;

/**
 * Application exception represents a checked exception.
 * 
 */
public class OpenBdtRuntimeException extends Exception {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -6284995107126350183L;

	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public OpenBdtRuntimeException(final String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public OpenBdtRuntimeException(final Throwable cause) {
		super(cause);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param message	- String
	 * @param cause 	- Throwable
	 */
	public OpenBdtRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
}
