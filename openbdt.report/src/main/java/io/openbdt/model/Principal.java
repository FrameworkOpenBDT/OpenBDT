package io.openbdt.model;

import java.io.Serializable;
import java.util.List;


public class Principal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4376696552403472696L;
	
	private String name;
	private String id;
	private List<TestStep> testSteps = null;
	private UserStory userStory;
	private FeatureTag featureTag;
	private String title;
	private String description;
	private List<Tag> tags = null;
	private Long startTime;
	private Long duration;
	private String projectKey;
	private DataTable dataTable;
	private Boolean manual;
	private String result;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<TestStep> getTestSteps() {
		return testSteps;
	}
	public void setTestSteps(List<TestStep> testSteps) {
		this.testSteps = testSteps;
	}
	public UserStory getUserStory() {
		return userStory;
	}
	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}
	public FeatureTag getFeatureTag() {
		return featureTag;
	}
	public void setFeatureTag(FeatureTag featureTag) {
		this.featureTag = featureTag;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public DataTable getDataTable() {
		return dataTable;
	}
	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}
	public Boolean getManual() {
		return manual;
	}
	public void setManual(Boolean manual) {
		this.manual = manual;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
