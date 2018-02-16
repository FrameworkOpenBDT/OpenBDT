package br.com.rsi.framework.bdd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.openbdt.exception.ValidationException;
import io.openbdt.validation.ValidationHelper;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ValidationHelper.class)
public class TestValidationHelper {
	
	@Autowired
	private ValidationHelper validate;

	@Test(expected = ValidationException.class)
	public void testObjectIsNull() {
		this.validate.isObjectNull(null);
	}
	
	@Test
	public void testObjectIsNullWithCustomMessage() {
		final String customMessage = ">>> Object null";
		
		try {
			this.validate.isObjectNull(null, customMessage);
		} catch (ValidationException e) {
			Assert.assertEquals(e.getMessage(), customMessage);
		}
	}
	
	@Test(expected = ValidationException.class)
	public void testStringIsNull() {
		this.validate.isStringEmpty(null);
	}
	
	@Test
	public void testStringIsNullWithCustomMessage() {
		final String customMessage = ">>> String null";
		
		try {
			this.validate.isStringEmpty(null, customMessage);
		} catch (ValidationException e) {
			Assert.assertEquals(e.getMessage(), customMessage);
		}
	}
	
	@Test
	public void testObjectIsNotNull() {
		this.validate.isObjectNull(new Object());
	}
	
	@Test
	public void testObjectIsNotNullWithCustomMessage() {
		this.validate.isObjectNull(new Object(), "not null");
	}
	
	@Test
	public void testStringIsNotNull() {
		this.validate.isStringEmpty(" teste ");
	}
	
	@Test
	public void testStringIsNotNullWithCustomMessage() {
		this.validate.isStringEmpty("not null", "message");
	}
}
