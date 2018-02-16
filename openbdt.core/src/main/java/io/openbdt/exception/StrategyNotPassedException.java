package io.openbdt.exception;

public class StrategyNotPassedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2848452747189514568L;

	public StrategyNotPassedException(Throwable t) {
		super(t);
	}
	
	public StrategyNotPassedException(String message) {
		super(message);
	}
	
	public StrategyNotPassedException(String message, Throwable t) {
		super(message, t);
	}
}
