package io.openbdt.api;

import java.util.List;

public interface AppElement<Element, CriteriaSearch> extends ViewElement {
	
	/**
	 * Click the element
	 * 
	 */
	void click(Element element);
	
	/**
	 * Send specified text to the element
	 * 
	 * @param textToSend - String
	 */
	void sendText(String textToSend);
	
	/**
	 * Clear element
	 */
	void clear(Element element);
	
	/**
	 * Verify if element is selected
	 * 
	 * @return boolean TRUE is selected
	 */
	boolean isSelected(Element element);
	
	/**
	 * Verify if element is enable
	 * 
	 * @return boolean TRUE is enable
	 */
	boolean isEnabled(Element element);
	
	/**
	 * Get text of the element
	 * 
	 * @return String 
	 */
	String getText(Element element);
	
	/**
	 * Find a list of elements by specified criteria
	 * 
	 * @param criteria - Criteria to search a list of element
	 * 
	 * @return List<Element> - List of the element found
	 */
	List<Element> findElements(CriteriaSearch criteria);
	
	/**
	 * Find an elements by specified criteria
	 * 
	 * @param criteria - Criteria to search an element
	 * 
	 * @param criteria
	 * 
	 * @return Element - Element found by criteria 
	 */
	Element findElement(CriteriaSearch criteria);
}
