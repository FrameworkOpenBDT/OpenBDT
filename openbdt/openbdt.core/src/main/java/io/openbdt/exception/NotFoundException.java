package io.openbdt.exception;

/**
 * 
 * Exception to be throw when not found some resources
 *
 */
public class NotFoundException extends RuntimeException {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 1590987562455940520L;

	/**
	 * @param message
	 *            - String
	 */
	public NotFoundException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 *            - String
	 */
	public NotFoundException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            - String
	 * @param cause
	 *            - Throwable
	 */
	public NotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
