package io.openbdt.listener;

import java.util.logging.Logger;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import io.openbdt.log.LogHelper;

/**
 * Listener events execution test by Junit
 * 
 */
public final class RunListenerJunit extends RunListener {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(RunListenerJunit.class.getName());

	/**
	 * On test failure
	 * 
	 * @param failure - Failure
	 * 
	 * @throws Exception
	 */
	@Override
	public void testFailure(final Failure failure) throws Exception {
		LOG.info("test Failure: " + failure);
		super.testFailure(failure);
	}

	
	/**
	 * On test assumption failure
	 * 
	 * @param failure - Failure
	 * 
	 * @throws Exception
	 */
	@Override
	public void testAssumptionFailure(final Failure failure) {
		LOG.info("test Assumption Failure: " + failure);
		super.testAssumptionFailure(failure);
	}

	
	/**
	 * On test finished
	 * 
	 * @param description - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testFinished(final Description description) throws Exception {
		LOG.info("test finished: " + description);
		super.testFinished(description);
	}

	
	/**
	 * On test ignored
	 * 
	 * @param description - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testIgnored(final Description description) throws Exception {
		LOG.info("test ignored: " + description);
		super.testIgnored(description);
	}

	
	/**
	 * On test ignored
	 * 
	 * @param description - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testRunFinished(final Result result) throws Exception {
		LOG.info("test run finished: " + result);
		super.testRunFinished(result);
	}

	
	/**
	 * On test run started
	 * 
	 * @param description - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testRunStarted(final Description description) throws Exception {
		// print OpenBdt
		LOG.info(LogHelper.getLogger());
		
		LOG.info("test run started: " + description);
		super.testRunStarted(description);
	}

	/**
	 * On test started
	 * 
	 * @param description - Description
	 * 
	 * @throws Exception
	 */
	@Override
	public void testStarted(final Description description) throws Exception {
		LOG.info("test started: " + description);
		super.testStarted(description);
	}
}
