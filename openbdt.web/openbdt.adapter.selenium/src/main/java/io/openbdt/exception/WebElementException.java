package io.openbdt.exception;

/**
 * Exception will be throw when ocurr error in interaction with web view element.
 *
 */
public class WebElementException extends ElementException {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -7710355777899174192L;

	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public WebElementException(String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public WebElementException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message 	- String
	 * @param cause		- Throwable
	 */
	public WebElementException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
