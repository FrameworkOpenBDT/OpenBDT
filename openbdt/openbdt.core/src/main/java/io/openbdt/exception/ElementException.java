package io.openbdt.exception;

/**
 * Exception will be throw when ocurr error in interaction with view element.
 *
 */
public class ElementException extends RuntimeException {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 1415040354382287458L;

	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public ElementException(String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public ElementException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message 	- String
	 * @param cause		- Throwable
	 */
	public ElementException(String message, Throwable cause) {
		super(message, cause);
	}
}