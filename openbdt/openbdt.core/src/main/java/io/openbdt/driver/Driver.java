package io.openbdt.driver;

import java.util.Map;

import io.openbdt.exception.InstantiateDriverException;

/**
 * Interface to interact to the specific Driver<br>
 * 
 * @param <TypeDriver><br>
 */
public interface Driver<TypeDriver, TypeViewElement> {

	/**
	 * Load driver<br>
	 * 
	 * @param typeDriver - TypeDriver<br>
	 * 
	 * @param properties - Map<String, String><br>
	 * 
	 * @throws InstantiateDriverException<br>
	 */
	TypeViewElement open(TypeDriver typeDriver, Map<String, String> properties) throws InstantiateDriverException;
	
}
