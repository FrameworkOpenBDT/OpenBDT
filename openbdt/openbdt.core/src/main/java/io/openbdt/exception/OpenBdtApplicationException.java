package io.openbdt.exception;

/**
 * Exception represents a checked exception.
 * 
 */
public class OpenBdtApplicationException extends Exception {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -6284995107126350183L;

	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public OpenBdtApplicationException(final String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public OpenBdtApplicationException(final Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message	- String
	 * @param cause 	- Throwable
	 */
	public OpenBdtApplicationException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
}
