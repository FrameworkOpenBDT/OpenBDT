package io.openbdt.exception;

public class ApplicationViewIsRequiredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499534004107778686L;

	public ApplicationViewIsRequiredException(Throwable t) {
		super(t);
	}
	
	public ApplicationViewIsRequiredException(String message) {
		super(message);
	}
	
	public ApplicationViewIsRequiredException(String message, Throwable t) {
		super(message, t);
	}
}
