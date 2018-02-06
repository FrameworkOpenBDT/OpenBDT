package io.openbdt.exception;

public class StrategyNotSupportedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1932122727589690743L;

	public StrategyNotSupportedException(Throwable t) {
		super(t);
	}
	
	public StrategyNotSupportedException(String message) {
		super(message);
	}
	
	public StrategyNotSupportedException(String message, Throwable t) {
		super(message, t);
	}
}
