package io.openbdt.exception;

public class AnUniqueApplicationViewIsRequiredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499534004107778686L;

	public AnUniqueApplicationViewIsRequiredException(Throwable t) {
		super(t);
	}
	
	public AnUniqueApplicationViewIsRequiredException(String message) {
		super(message);
	}
	
	public AnUniqueApplicationViewIsRequiredException(String message, Throwable t) {
		super(message, t);
	}
}
