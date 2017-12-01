package io.openbdt.listener;

import org.apache.log4j.Logger;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import io.openbdt.log.LogHelper;

/**
 * Suite test Listener
 * 
 * @author regis.rocha
 *
 */
public final class SuiteTestListener extends RunListener {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(SuiteTestListener.class.getName());

	@Override
	public void testFailure(final Failure failure) throws Exception {
		LOG.info("test Failure: " + failure);

		super.testFailure(failure);
	}

	@Override
	public void testAssumptionFailure(final Failure failure) {
		LOG.info("test Assumption Failure: " + failure);

		super.testAssumptionFailure(failure);
	}

	@Override
	public void testFinished(final Description description) throws Exception {
		LOG.info("test finished: " + description);

		super.testFinished(description);
	}

	@Override
	public void testIgnored(final Description description) throws Exception {
		LOG.info("test ignored: " + description);

		super.testIgnored(description);
	}

	@Override
	public void testRunFinished(Result result) throws Exception {
		LOG.info("test run finished: " + result);

		super.testRunFinished(result);
	}

	@Override
	public void testRunStarted(final Description description) throws Exception {
		LOG.info(LogHelper.getLogger());
		
		LOG.info("test run started: " + description);

		super.testRunStarted(description);
	}

	@Override
	public void testStarted(final Description description) throws Exception {
		LOG.info("test started: " + description);

		super.testStarted(description);
	}
}
