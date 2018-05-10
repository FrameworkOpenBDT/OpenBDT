package io.openbdt.exception;

public class DriverNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1813332016922231031L;

	/**
	 * 
	 * @param message
	 */
	public DriverNotExistException(final String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param t
	 */
	public DriverNotExistException(final Throwable t) {
		super(t);
	}
	
	/**
	 * 
	 * @param message
	 * @param t
	 */
	public DriverNotExistException(final String message, final Throwable t) {
		super(message, t);
	}
}
