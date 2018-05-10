package io.openbdt.element;

import java.util.List;

import org.openqa.selenium.winium.WiniumDriver;

import io.openbdt.api.ViewElement;

public interface WindowView<Element, CriteriaSearch, Driver extends WiniumDriver> extends ViewElement {

	/**
	 * Driver
	 */
	Driver getDriver();

	/**
	 * Click the element
	 * 
	 * @param element
	 *            - Element
	 * 
	 */
	void click(Element element);

	/**
	 * Click the in the specified elements
	 * 
	 * @param elements
	 *            - Element[]
	 * 
	 */
	void click(Element... elements);

	/**
	 * Click the element and wait specified time
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @param timeoutSeconds
	 *            - int (seconds)
	 * 
	 */
	void clickAndWait(Element element, int timeoutSeconds);

	/**
	 * Click the in the specified elements
	 * 
	 * @param timeoutSeconds
	 *            - int
	 * 
	 * @param elements
	 *            - Element[]
	 * 
	 */
	void clickAndWait(int timeoutSeconds, Element... elements);

	/**
	 * Wait specified element to be clickable and click it.
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @param timeoutSeconds
	 *            - int
	 * 
	 */
	public void waitAndClick(final Element element, final int timeoutSeconds);

	/**
	 * Submit form
	 * 
	 * @param element
	 *            - Element
	 * 
	 */
	void submit(Element element);

	/**
	 * Send specified text to the element
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @param textToSend
	 *            - String
	 */
	void sendText(Element element, String textToSend);

	/**
	 * Clear element
	 * 
	 * @param element
	 *            - Element
	 * 
	 */
	void clear(Element element);

	/**
	 * Verify if element is selected
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @return boolean TRUE is selected
	 */
	boolean isSelected(Element element);

	/**
	 * Verify if element is enable
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @return boolean TRUE is enable
	 */
	boolean isEnabled(Element element);

	/**
	 * Get text of the element
	 * 
	 * @param element
	 *            - Element
	 * 
	 * @return String
	 */
	String getText(Element element);

	/**
	 * Find a list of elements by specified criteria
	 * 
	 * @param criteria
	 *            - Criteria to search a list of element
	 * 
	 * @return List<Element> - List of the element found
	 */
	List<Element> findElements(CriteriaSearch criteria);

	/**
	 * Find an elements by specified criteria
	 * 
	 * @param criteria
	 *            - Criteria to search an element
	 * 
	 * @return Element - Element found by criteria
	 */
	Element findElement(CriteriaSearch criteria);

	/**
	 * Select by visible text
	 * 
	 * @param element
	 *            - Element
	 * @param text
	 *            - String
	 */
	void selectByVisibleText(Element element, String text);

	/**
	 * Select by value
	 * 
	 * @param element
	 *            - Element
	 * @param value
	 *            - String
	 */
	void selectByValue(Element element, String value);

	/**
	 * Select by index
	 * 
	 * @param element
	 *            - Element
	 * @param index
	 *            - int
	 */
	void selectByIndex(Element element, int index);
}
