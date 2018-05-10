package io.openbdt.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ExecutionManager {
	@Before
	public void before() {
		System.out.println("##########");
		System.out.println("before()");
		System.out.println("##########");
	}
	
	@After
	public void after() {
		System.out.println("##########");
		System.out.println("after()");
		System.out.println("##########");
	}
	
}
