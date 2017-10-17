package io.openbdt.exception;

import io.openbdt.exception.OpenBdtApplicationException;

public class ReportException extends OpenBdtApplicationException {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 4433479963342630314L;

	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public ReportException(final String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public ReportException(final Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message	- String
	 * @param cause 	- Throwable
	 */
	public ReportException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
}
