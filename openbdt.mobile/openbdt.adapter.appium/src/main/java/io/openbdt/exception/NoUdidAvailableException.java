package io.openbdt.exception;

public class NoUdidAvailableException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6499396118122648639L;

	public NoUdidAvailableException(Throwable t) {
		super(t);
	}
	
	public NoUdidAvailableException(String message) {
		super(message);
	}
	
	public NoUdidAvailableException(String message, Throwable t) {
		super(message, t);
	}
}
