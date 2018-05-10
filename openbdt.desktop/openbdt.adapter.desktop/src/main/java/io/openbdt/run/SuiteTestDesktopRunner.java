package io.openbdt.run;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.openbdt.driver.DesktopDriver;
import io.openbdt.listener.CustomRunListenerJunitDesktop;

/**
 * Execute suite test runner with Junit
 * 
 */
@Component
public class SuiteTestDesktopRunner {
	
	@Autowired
	private DesktopDriver desktopDriver;
	
	public SuiteTestDesktopRunner() {}

	public Result runWithJunit(final Class<?> clazz) {
		final JUnitCore junit = new JUnitCore();
		
		junit.addListener(new CustomRunListenerJunitDesktop(this.desktopDriver));
		
		return junit.run(clazz);
	}
}
