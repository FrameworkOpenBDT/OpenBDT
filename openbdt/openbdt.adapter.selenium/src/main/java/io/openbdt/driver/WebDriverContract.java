package io.openbdt.driver;

public interface WebDriverContract<TypeDriver, TypeViewElement> extends Driver<TypeDriver, TypeViewElement> {

	/**
	 * get reference to the view object
	 * 
	 * @return TypeViewElement
	 */
	TypeViewElement getViewElement();
	
}
