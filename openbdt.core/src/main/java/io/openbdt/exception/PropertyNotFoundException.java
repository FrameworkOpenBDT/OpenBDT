package io.openbdt.exception;

public class PropertyNotFoundException extends OpenBdtRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message
	 *            - String
	 */
	public PropertyNotFoundException(final String message) {
		super(message);
	}

	/**
	 * Constructor
	 * 
	 * @param cause
	 *            - Throwable
	 */
	public PropertyNotFoundException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor
	 * 
	 * @param message
	 *            - String
	 * @param cause
	 *            - Throwable
	 */
	public PropertyNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
