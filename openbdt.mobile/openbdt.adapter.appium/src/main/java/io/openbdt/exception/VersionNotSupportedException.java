package io.openbdt.exception;

public class VersionNotSupportedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7113310816717785839L;

	public VersionNotSupportedException(Throwable t) {
		super(t);
	}
	
	public VersionNotSupportedException(String message) {
		super(message);
	}
	
	public VersionNotSupportedException(String message, Throwable t) {
		super(message, t);
	}
}
