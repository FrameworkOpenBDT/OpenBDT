package io.openbdt.listener;

import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import io.openbdt.log.LogHelper;
import junit.framework.Assert;
import net.thucydides.core.model.DataTable;
import net.thucydides.core.model.Story;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepFailure;
import net.thucydides.core.steps.StepListener;

/**
 * Listener Step serenity
 * 
 */
public class CustomStepListener implements StepListener {
	
	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(CustomStepListener.class.getName());

	/**
	 * On test suite started
	 * 
	 * @param storyClass - Class<?>
	 * 
	 */
	@Override
	public void testSuiteStarted(final Class<?> storyClass) {
		LOG.info("Serenity test suite started: " + storyClass != null ? storyClass.getName() : "");
	}

	
	/**
	 * On test suite started
	 * 
	 * @param story - Story
	 * 
	 */
	@Override
	public void testSuiteStarted(final Story story) {
		LOG.info(LogHelper.getLogger());
		LOG.info("Serenity test suite started story: " + story != null ? story.getName() : "");
	}

	
	/**
	 * On test suite finished
	 * 
	 */
	@Override
	public void testSuiteFinished() {
		LOG.info("Serenity test suite finished: "
				+ (System.getProperty("junit.step.failed") != null?"Some step failed":"Steps successfully executed"));
		if(System.getProperty("junit.step.failed") != null)
			Assert.assertTrue(false);
	}

	
	/**
	 * On test started
	 * 
	 * @param description - String
	 * 
	 */
	@Override
	public void testStarted(final String description) {
		LOG.info("Serenity test started: " + description);
	}

	
	/**
	 * On test finished
	 * 
	 * @param result - TestOutcome
	 * 
	 */
	@Override
	public void testFinished(final TestOutcome result) {
		LOG.info("Serenity test finished: " + result.toString());
	}

	
	/**
	 * On test retried
	 * 
	 */
	@Override
	public void testRetried() {
		LOG.info("Serenity test retried");
	}

	
	/**
	 * On test started
	 * 
	 * @param description - ExecutedStepDescription
	 * 
	 */
	@Override
	public void stepStarted(final ExecutedStepDescription description) {
		LOG.info("Serenity test started: " + description.getName());
	}

	
	/**
	 * On test skipped step started
	 * 
	 * @param description - ExecutedStepDescription
	 * 
	 */
	@Override
	public void skippedStepStarted(final ExecutedStepDescription description) {
		LOG.info("Serenity test skipped step started: " + description.getName());
	}

	
	/**
	 * On test failed
	 * 
	 * @param failure - StepFailure
	 * 
	 */
	@Override
	public void stepFailed(final StepFailure failure) {
		String cause = "";
		if (failure.getException() != null && failure.getException().getLocalizedMessage() != null
				&& StringUtils.isNotBlank(failure.getException().getLocalizedMessage())) {
			
			cause = failure.getException().getLocalizedMessage();
		}
		System.setProperty("junit.step.failed", "true");
		LOG.info("Serenity test failure: " + cause);
	}

	
	/**
	 * On last step failed
	 * 
	 * @param failure - StepFailure
	 * 
	 */
	@Override
	public void lastStepFailed(final StepFailure failure) {
		String cause = "";
		if (failure.getException() != null && failure.getException().getLocalizedMessage() != null
				&& StringUtils.isNotBlank(failure.getException().getLocalizedMessage())) {
			
			cause = failure.getException().getLocalizedMessage();
		}
		
		LOG.info("Serenity last step failure: " + cause);
	}

	
	/**
	 * On step ignored
	 * 
	 */
	@Override
	public void stepIgnored() {
		LOG.info("Serenity step ignored");
	}

	
	/**
	 * On step pending
	 * 
	 */
	@Override
	public void stepPending() {
		LOG.info("Serenity step pending");
	}

	
	/**
	 * On step pending
	 * 
	 * @param message - String
	 */
	@Override
	public void stepPending(final String message) {
		LOG.info("Serenity step pending: " + message);
	}

	
	/**
	 * On step finished
	 * 
	 */
	@Override
	public void stepFinished() {
		LOG.info("Serenity step finished");
	}

	
	/**
	 * On step failed
	 * 
	 * @param testOutcome 	- TestOutcome
	 * 
	 * @param cause			- Throwable
	 * 
	 */
	@Override
	public void testFailed(final TestOutcome testOutcome, final Throwable cause) {
		String causeMessage = "";
		if (cause != null && StringUtils.isNotBlank(cause.getMessage())) {
			causeMessage = cause.getMessage();
		}
		
		LOG.info("Serenity test failed: " + testOutcome != null ? testOutcome.toString() : "" + causeMessage);
	}

	
	/**
	 * On test ignored
	 * 
	 */
	@Override
	public void testIgnored() {
		LOG.info("Serenity test ignored");
	}

	
	/**
	 * On test skipped
	 * 
	 */
	@Override
	public void testSkipped() {
		LOG.info("Serenity test skipped");
	}

	
	/**
	 * On test pending
	 * 
	 */
	@Override
	public void testPending() {
		LOG.info("Serenity test pending");
	}

	
	/**
	 * On notify screen change
	 * 
	 */
	@Override
	public void notifyScreenChange() {
		LOG.info("Serenity notifying screen change");
	}

	
	/**
	 * On notify screen change
	 * 
	 * @param table - DataTable
	 * 
	 */
	@Override
	public void useExamplesFrom(final DataTable table) {
		LOG.info("Serenity using examples from: ");

		try {
			if (table != null && table.getHeaders() != null) {
				final StringBuilder headers = new StringBuilder();
				
				table.getHeaders().forEach(h -> {
					headers.append(h).append("|");
				});
				
				LOG.info("Headers: \n" + headers.toString());
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
		}
	}

	
	/**
	 * On examples started
	 * 
	 * @param table - Map<String, String>
	 * 
	 */
	@Override
	public void exampleStarted(final Map<String, String> data) {
		LOG.info("Serenity examples started: ");
		
		try {
			if (data != null) {
				final Set<String> keySet = data.keySet();
				
				keySet.forEach(k -> {
					LOG.info(k + data.get(k));
				});
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "", e);
		}
	}

	
	/**
	 * On examples finished
	 * 
	 */
	@Override
	public void exampleFinished() {
		LOG.info("Serenity examples finished");
	}

	
	/**
	 * On assumption violated
	 * 
	 * @param message - String
	 * 
	 */
	@Override
	public void assumptionViolated(final String message) {
		LOG.info("Serenity assumption violated: " + message);
	}
}
