
package io.openbdt.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.openbdt.exception.ReportException;
import io.openbdt.helper.StatusCouter;

/**
 * Classe POJO principal, utilizada para fazer o parse do Json utilizando o
 * Jackson Project, demais POJOS compõem esta classe.
 * 
 * @author caio.moraes
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "id", "testSteps", "userStory", "featureTag", "title", "description", "tags", "startTime",
		"duration", "testFailureCause", "testFailureClassname", "testFailureMessage", "testFailureSummary",
		"projectKey", "dataTable", "manual", "result" })
public class Feature {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(Feature.class.getName());

	@JsonProperty("name")
	private String name;
	@JsonProperty("id")
	private String id;
	@JsonProperty("testSteps")
	private List<TestStep> testSteps = null;
	@JsonProperty("userStory")
	private UserStory userStory;
	@JsonProperty("featureTag")
	private FeatureTag featureTag;
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@JsonProperty("tags")
	private List<Tag> tags = null;
	@JsonProperty("startTime")
	private String startTime;
	@JsonProperty("duration")
	private Integer duration;
	@JsonProperty("testFailureCause")
	private TestFailureCause testFailureCause;
	@JsonProperty("testFailureClassname")
	private String testFailureClassname;
	@JsonProperty("testFailureMessage")
	private String testFailureMessage;
	@JsonProperty("testFailureSummary")
	private String testFailureSummary;
	@JsonProperty("projectKey")
	private String projectKey;
	@JsonProperty("dataTable")
	private DataTable dataTable;
	@JsonProperty("manual")
	private Boolean manual;
	@JsonProperty("result")
	private String result;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("testSteps")
	public List<TestStep> getTestSteps() {
		return testSteps;
	}

	@JsonProperty("testSteps")
	public void setTestSteps(List<TestStep> testSteps) {
		this.testSteps = testSteps;
	}

	@JsonProperty("userStory")
	public UserStory getUserStory() {
		return userStory;
	}

	@JsonProperty("userStory")
	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	@JsonProperty("featureTag")
	public FeatureTag getFeatureTag() {
		return featureTag;
	}

	@JsonProperty("featureTag")
	public void setFeatureTag(FeatureTag featureTag) {
		this.featureTag = featureTag;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("tags")
	public List<Tag> getTags() {
		return tags;
	}

	@JsonProperty("tags")
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@JsonProperty("startTime")
	public String getStartTime() {
		return startTime;
	}

	@JsonProperty("startTime")
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@JsonProperty("duration")
	public Integer getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@JsonProperty("testFailureCause")
	public TestFailureCause getTestFailureCause() {
		return testFailureCause;
	}

	@JsonProperty("testFailureCause")
	public void setTestFailureCause(TestFailureCause testFailureCause) {
		this.testFailureCause = testFailureCause;
	}

	@JsonProperty("testFailureClassname")
	public String getTestFailureClassname() {
		return testFailureClassname;
	}

	@JsonProperty("testFailureClassname")
	public void setTestFailureClassname(String testFailureClassname) {
		this.testFailureClassname = testFailureClassname;
	}

	@JsonProperty("testFailureMessage")
	public String getTestFailureMessage() {
		return testFailureMessage;
	}

	@JsonProperty("testFailureMessage")
	public void setTestFailureMessage(String testFailureMessage) {
		this.testFailureMessage = testFailureMessage;
	}

	@JsonProperty("testFailureSummary")
	public String getTestFailureSummary() {
		return testFailureSummary;
	}

	@JsonProperty("testFailureSummary")
	public void setTestFailureSummary(String testFailureSummary) {
		this.testFailureSummary = testFailureSummary;
	}

	@JsonProperty("projectKey")
	public String getProjectKey() {
		return projectKey;
	}

	@JsonProperty("projectKey")
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	@JsonProperty("dataTable")
	public DataTable getDataTable() {
		return dataTable;
	}

	@JsonProperty("dataTable")
	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}

	@JsonProperty("manual")
	public Boolean getManual() {
		return manual;
	}

	@JsonProperty("manual")
	public void setManual(Boolean manual) {
		this.manual = manual;
	}

	@JsonProperty("result")
	public String getResult() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(String result) {
		this.result = result;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Resume getFeatureStatus() throws ReportException {

		Resume sumResult = null;
		try {

			sumResult = StatusCouter.sumResult(this);

		} catch (ReportException e) {
			LOG.fatal(e.getMessage(), e);
			throw new ReportException(e);
		}
		return sumResult;
	}

}
