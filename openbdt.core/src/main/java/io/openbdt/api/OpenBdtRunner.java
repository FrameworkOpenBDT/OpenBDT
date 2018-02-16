package io.openbdt.api;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public final class OpenBdtRunner extends SpringJUnit4ClassRunner {

	/**
	 * Construct a new {@code OpenBdtRunner} and initialize a
	 * {@link org.springframework.test.context.TestContextManager TestContextManager}
	 * to provide OpenBdt testing functionality to standard JUnit 4 tests.
	 * 
	 * @param clazz the test class to be run
	 * @see #createTestContextManager(Class)
	 */
	public OpenBdtRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}	
}
