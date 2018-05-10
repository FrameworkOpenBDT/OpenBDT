package io.openbdt.driver;

import io.openbdt.types.MobileDriverType;

public interface MobileDriverContract<TypeDriver extends MobileDriverType , TypeViewElement> extends Driver<TypeDriver, TypeViewElement> {

	/**
	 * get reference to the view object
	 * 
	 * @return TypeViewElement
	 */
	TypeViewElement getViewElement();
}
