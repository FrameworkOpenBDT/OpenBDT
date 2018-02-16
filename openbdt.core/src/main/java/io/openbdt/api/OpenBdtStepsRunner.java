package io.openbdt.api;

import java.io.IOException;

import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

public class OpenBdtStepsRunner extends Cucumber {

	public OpenBdtStepsRunner(Class<?> clazz) throws InitializationError, IOException {
		super(clazz);
	}

}
