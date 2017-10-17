package io.openbdt.exception;

public class InstantiateDriverException extends OpenBdtRuntimeException {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -11125609735485553L;


	/**
	 * Constructor
	 * 
	 * @param message - String
	 */
	public InstantiateDriverException(final String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public InstantiateDriverException(final Throwable cause) {
		super(cause);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param message	- String
	 * @param cause 	- Throwable
	 */
	public InstantiateDriverException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
