package io.openbdt.serenity.plugin;

import java.util.List;
import java.util.logging.Logger;

import gherkin.formatter.Formatter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

/**
 * Plugin to report format
 * 
 * @author regis.rocha
 *
 */
public class FormatterReportPlugin implements Formatter {

	/**
	 * LOG
	 */
	private Logger LOG = Logger.getLogger(FormatterReportPlugin.class.getName());
	
	
	/**
     * Is called in case any syntax error was detected during the parsing of the feature files.
     *
     * @param state the current state of the parser machine
     * @param event detected event
     * @param legalEvents expected event
     * @param uri the URI of the feature file
     * @param line the line number of the event
     * 
     */
	@Override
	public void syntaxError(final String state, final String event, final List<String> legalEvents, final String uri, final Integer line) {
		final StringBuilder printSyntaxError = new StringBuilder();
		
		printSyntaxError.append("State: ").append(state).append(" event: ").append(event).append(" uri: ").append(uri).append(" line: ").append(line);
		
		LOG.info("formatter: syntax error state: > " + printSyntaxError.toString());
	}

	
	/**
     * Called at the beginning of each feature.
     *
     * @param uri the feature's URI
     */
	@Override
	public void uri(final String uri) {
		LOG.info("formatter: uri > " + uri);
	}

	
	/**
     * Called after the {@link Formatter#uri(String)}, but before the actual feature execution.
     *
     * @param feature the to be executed {@linkplain Feature}
     */
	@Override
	public void feature(final Feature feature) {
		if (feature != null) {
			LOG.info("formatter: feature > " + feature.getName());
		}
	}

	
	/**
     * Called before the actual execution of the scenario outline step container.
     *
     * @param scenarioOutline the to be executed {@link ScenarioOutline}
     * 
     */
	@Override
	public void scenarioOutline(final ScenarioOutline scenarioOutline) {
		if (scenarioOutline != null) {
			LOG.info("formatter: scenario outline " + scenarioOutline.getName());
		}
	}

	
	/**
     * Called before the actual execution of the scenario examples. This is called after
     * the {@link Formatter#scenarioOutline(gherkin.formatter.model.ScenarioOutline)},
     * but before any actual scenario example.
     *
     * @param examples the to be executed
     * 
     */
	@Override
	public void examples(final Examples examples) {
		if (examples != null) {
			LOG.info("formatter: examples " + examples.getName());
		}
	}

	
	/**
     * Is called at the beginning of the scenario life cycle, meaning before the first "before" hook.
     * 
     * @param scenario the {@link Scenario} of the current lifecycle
     * 
     */
	@Override
	public void startOfScenarioLifeCycle(final Scenario scenario) {
		if (scenario != null) {
			LOG.info("formatter: start Of Scenario Life Cycle " + scenario.getName());
		}
	}

	
	/**
     * Called before the actual execution of the background step container.
     *
     * @param background the to be executed {@link Background}
     * 
     */
	@Override
	public void background(final Background background) {
		if (background != null) {
			LOG.info("formatter: background " + background.getName());
		}
	}

	
	/**
     * Called before the actual execution of the scenario step container.
     *
     * @param scenario the to be executed {@link Scenario}
     */
	@Override
	public void scenario(final Scenario scenario) {
		if (scenario != null) {
			LOG.info("formatter: scenario " + scenario.getName());
		}
	}

	
	/**
     * Is called for each step of a step container. <b>Attention:</b> All steps are iterated through
     * this method before any step is actually executed.
     *
     * @param step the {@link Step} to be executed
     * 
     */
	@Override
	public void step(final Step step) {
		if (step != null) {
			LOG.info("formatter: step " + step.getName());
		}
	}

	
	/**
     * Is called at the end of the scenario life cycle, meaning after the last "after" hook.
     * 
     * @param scenario the {@link Scenario} of the current lifecycle
     * 
     */
	@Override
	public void endOfScenarioLifeCycle(Scenario scenario) {
		if (scenario != null) {
			LOG.info("formatter: end Of Scenario LifeCycle " + scenario.getName());
		}
	}

	
	/**
     * Indicates that the last file has been processed. This should print out any closing output,
     * such as completing the JSON string, but it should *not* close any underlying streams/writers.
     */
	@Override
	public void done() {
		LOG.info("formatter: done ");
	}

	
	/**
     * Closes all underlying streams.
     */
	@Override
	public void close() {
		LOG.info("formatter: close ");
	}

	
	/**
     * Indicates the End-Of-File for a Gherkin document (.feature file)
     */
	@Override
	public void eof() {
		LOG.info("formatter: end of file Gherkin document (.feature file) ");
	}
}
