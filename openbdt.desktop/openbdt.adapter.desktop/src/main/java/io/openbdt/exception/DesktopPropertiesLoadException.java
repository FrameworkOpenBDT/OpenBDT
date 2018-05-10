package io.openbdt.exception;

public class DesktopPropertiesLoadException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499534004107778686L;

	public DesktopPropertiesLoadException(Throwable t) {
		super(t);
	}
	
	public DesktopPropertiesLoadException(String message) {
		super(message);
	}
	
	public DesktopPropertiesLoadException(String message, Throwable t) {
		super(message, t);
	}
}
