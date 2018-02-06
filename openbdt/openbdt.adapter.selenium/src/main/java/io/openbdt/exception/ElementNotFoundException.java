package io.openbdt.exception;

/**
 *  Exception to be throw when element is not found
 * 
 */
public class ElementNotFoundException extends NotFoundException {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -285738359507902223L;

	/**
	 * @param message
	 *            - String
	 */
	public ElementNotFoundException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 *            - String
	 */
	public ElementNotFoundException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            - String
	 * @param cause
	 *            - Throwable
	 */
	public ElementNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
}
