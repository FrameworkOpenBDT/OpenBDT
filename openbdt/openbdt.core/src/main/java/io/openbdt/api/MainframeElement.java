package io.openbdt.api;

public interface MainframeElement<Element, CriteriaSearch> extends ViewElement {

	/**
	 * Send specified text to the element
	 * 
	 * @param textToSend - String
	 */
	void sendText(String textToSend);
	
}
