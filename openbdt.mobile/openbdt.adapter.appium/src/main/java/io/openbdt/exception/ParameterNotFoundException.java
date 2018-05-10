package io.openbdt.exception;

/**
 * 
 * @author splait
 *
 */
public class ParameterNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5394462285806470335L;

	/**
	 * Constructor
	 * @param message Exception description
	 */
	public ParameterNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * @param throwable Cause of the exception
	 */
	public ParameterNotFoundException(Throwable throwable) {
		super(throwable);
	}
}
