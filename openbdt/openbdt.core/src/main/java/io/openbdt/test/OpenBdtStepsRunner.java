package io.openbdt.test;

import java.io.IOException;

import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

/**
 * <p>
 * Classes annotated with {@code @RunWith(OpenBdtStepsRunner.class)} will run a Feature.
 * The class should be empty without any fields or methods.
 * </p>
 * <p>
 * OpenBdtStepsRunner will look for a {@code .feature} file on the classpath, using the same resource
 * path as the annotated class ({@code .class} substituted by {@code .feature}).
 * </p>
 * Additional hints can be given to OpenBdtStepsRunner by annotating the class with {@link CucumberOptions}.
 *
 * @see RsiOptions
 */
public class OpenBdtStepsRunner extends Cucumber {
	
	public OpenBdtStepsRunner(Class<?> clazz) throws InitializationError, IOException {
		super(clazz);
	}
}
