package io.openbdt.exception;

public class WindowApplicationPropertyNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499534004107778686L;

	public WindowApplicationPropertyNotFoundException(Throwable t) {
		super(t);
	}
	
	public WindowApplicationPropertyNotFoundException(String message) {
		super(message);
	}
	
	public WindowApplicationPropertyNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
