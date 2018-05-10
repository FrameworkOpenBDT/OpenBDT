package io.openbdt.exception;

public class DriverAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2827665077891423998L;

	/**
	 * 
	 * @param message
	 */
	public DriverAlreadyExistException(final String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param t
	 */
	public DriverAlreadyExistException(final Throwable t) {
		super(t);
	}
	
	/**
	 * 
	 * @param message
	 * @param t
	 */
	public DriverAlreadyExistException(final String message, final Throwable t) {
		super(message, t);
	}
}
