package io.openbdt.run;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.openbdt.driver.MobileCustomDriver;
import io.openbdt.listener.CustomRunListenerJunit;

/**
 * Execute suite test runner with Junit
 * 
 */
@Component
public class SuiteTestMobileRunner {
	
	@Autowired
	private MobileCustomDriver mobileCustomDriver;
	
	public SuiteTestMobileRunner() {}

	public Result runWithJunit(final Class<?> clazz) {
		final JUnitCore junit = new JUnitCore();
		
		junit.addListener(new CustomRunListenerJunit(this.mobileCustomDriver));
		
		return junit.run(clazz);
	}
}
