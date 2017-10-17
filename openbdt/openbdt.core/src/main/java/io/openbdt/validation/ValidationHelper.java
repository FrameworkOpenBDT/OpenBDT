package io.openbdt.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import io.openbdt.exception.ValidationException;

/**
 * Helper class to validate if object is null or empty
 * 
 */
@Component
public class ValidationHelper {

	/**
	 * validate if object is null
	 * 
	 * @param object - Object
	 * 
	 * @return boolean - true if object is not null
	 * 
	 * @throws TypeValidationException - Will be throw if object is null
	 */
	public boolean isObjectNull(final Object object) throws ValidationException {
		if (object == null) {
			throw new ValidationException("Object is null");
		}
		
		return true;
	}
	
	/**
	 * validate if object is null
	 * 
	 * @param object 	- Object
	 * @param message 	- String
	 * 
	 * @return boolean - true if object is not null
	 * 
	 * @throws TypeValidationException - Will be throw if object is null
	 */
	public boolean isObjectNull(final Object object, final String messsage) throws ValidationException {
		if (object == null) {
			throw new ValidationException(messsage);
		}
		
		return true;
	}
	
	/**
	 * validate if String is empty
	 * 
	 * @param content - String
	 * 
	 * @return boolean - true if String is not null
	 * 
	 * @throws TypeValidationException - Will be throw if String is null
	 */
	public boolean isStringEmpty(final String content) throws ValidationException {
		this.isObjectNull(content);
		
		if (StringUtils.isBlank(content)) {
			throw new ValidationException("String is empty");
		}
		
		return true;
	}
	
	/**
	 * validate if String is empty
	 * 
	 * @param content - String
	 * 
	 * @return boolean - true if String is not null
	 * 
	 * @throws TypeValidationException - Will be throw if String is null
	 */
	public boolean isStringEmpty(final String content, final String message) throws ValidationException {
		this.isObjectNull(content, message);
		
		if (StringUtils.isBlank(content)) {
			throw new ValidationException(message);
		}
		
		return true;
	}
}
