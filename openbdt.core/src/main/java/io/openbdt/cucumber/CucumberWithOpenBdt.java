package io.openbdt.cucumber;

import java.io.IOException;

import org.junit.runners.model.InitializationError;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * 
 * @author regis.rocha
 * 
 * <p>
 * Classes annotated with {@code @RunWith(CucumberWithOpenBdt.class)} will run a Cucumber Feature.
 * The class should be empty without any fields or methods.
 * </p>
 * 
 */
public class CucumberWithOpenBdt extends CucumberWithSerenity {

	/**
	 * Constructor
	 * 
	 * @param clazz	- Class<?>
	 * 
	 * @throws InitializationError
	 * @throws IOException
	 */
	public CucumberWithOpenBdt(Class<?> clazz) throws InitializationError, IOException {
		super(clazz);
	}

	
	/**
	 * Creating runtime
	 * 
	 * @param resourceLoader 	- ResourceLoader
	 * @param classLoader		- ClassLoader
	 * @param runtimeOptions	- RuntimeOptions
	 * 
	 */
	protected cucumber.runtime.Runtime createRuntime(final ResourceLoader resourceLoader, final ClassLoader classLoader, final RuntimeOptions runtimeOptions) 
			throws InitializationError, IOException {
		
		return createEnabledRuntime(resourceLoader, classLoader, runtimeOptions);
	}

	
	/**
	 * 
	 * @param resourceLoader
	 * @param classLoader
	 * @param runtimeOptions
	 * 
	 * @return Runtime
	 */
	public static Runtime createEnabledRuntime(final ResourceLoader resourceLoader, final ClassLoader classLoader, final RuntimeOptions runtimeOptions) {
		final ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
		
		//final Configuration systemConfiguration = Injectors.getInjector().getInstance(Configuration.class);
		
		// add report plugin
		//runtimeOptions.addPlugin(new SerenityReporter(systemConfiguration, resourceLoader));
		
		// add report plugin
		//runtimeOptions.addPlugin(new FormatterReportPlugin());
		
		return new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
	}
}
