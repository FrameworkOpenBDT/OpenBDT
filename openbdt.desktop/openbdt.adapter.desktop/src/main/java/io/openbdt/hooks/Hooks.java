package io.openbdt.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.openbdt.driver.DesktopDriver;

@ContextConfiguration("/context.xml")
public class Hooks {

	@Autowired
	private DesktopDriver driver;
	
	@Before
	public void featureStarted() {
		System.out.println("###################");
		System.out.println("feature started");
		System.out.println("###################");
	}
	
	@After
	public void featureFinished() {
		System.out.println("###################");
		System.out.println("feature finished");
		System.out.println("###################");
		driver.getDriver().close();
	}
}
