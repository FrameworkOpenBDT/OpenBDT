package io.openbdt.exception;

public class WindowElementException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499534004107778686L;

	public WindowElementException(Throwable t) {
		super(t);
	}
	
	public WindowElementException(String message) {
		super(message);
	}
	
	public WindowElementException(String message, Throwable t) {
		super(message, t);
	}
}
