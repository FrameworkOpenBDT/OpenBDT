package io.openbdt.model;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import io.openbdt.exception.ReportException;
import io.openbdt.helper.StatusCouter;


public class Feature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4376696552403472696L;
	
	Logger LOG = Logger.getLogger(Feature.class);
	
    private String result;

    private UserStory userStory;

    private List<TestSteps> testSteps;

    private String projectKey;

    private String manual;

    private String id;

    private String startTime;

    private FeatureTag featureTag;
    
    private List<Tags> tags;

    private String title;

    private String duration;

    private String sessionId;

    private String name;

    private String testSource;

    private String driver;

    private DataTable dataTable;

    public List<Tags> getTags ()
    {
        return tags;
    }

    public void setTags (List<Tags> tags)
    {
        this.tags = tags;
    }

    public String getResult ()
    {
        return result;
    }

    public void setResult (String result)
    {
        this.result = result;
    }

    public UserStory getUserStory ()
    {
        return userStory;
    }

    public void setUserStory (UserStory userStory)
    {
        this.userStory = userStory;
    }

    public List<TestSteps> getTestSteps ()
    {
        return testSteps;
    }

    public void setTestSteps (List<TestSteps> testSteps)
    {
        this.testSteps = testSteps;
    }

    public String getProjectKey ()
    {
        return projectKey;
    }

    public void setProjectKey (String projectKey)
    {
        this.projectKey = projectKey;
    }

    public String getManual ()
    {
        return manual;
    }

    public void setManual (String manual)
    {
        this.manual = manual;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getStartTime ()
    {
        return startTime;
    }

    public void setStartTime (String startTime)
    {
        this.startTime = startTime;
    }

    public FeatureTag getFeatureTag ()
    {
        return featureTag;
    }

    public void setFeatureTag (FeatureTag featureTag)
    {
        this.featureTag = featureTag;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getSessionId ()
    {
        return sessionId;
    }

    public void setSessionId (String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getTestSource ()
    {
        return testSource;
    }

    public void setTestSource (String testSource)
    {
        this.testSource = testSource;
    }

    public String getDriver ()
    {
        return driver;
    }

    public void setDriver (String driver)
    {
        this.driver = driver;
    }

    public DataTable getDataTable ()
    {
        return dataTable;
    }

    public void setDataTable (DataTable dataTable)
    {
        this.dataTable = dataTable;
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

	@Override
    public String toString()
    {
        return "ClassPojo [result = " +result+ ", tags = [" + tags + "], userStory = "+userStory+", testSteps = "+testSteps+", projectKey = "+projectKey+", manual = "+manual+", id = "+id+", startTime = "+startTime+", featureTag = "+featureTag+", title = "+title+", duration = "+duration+", sessionId = "+sessionId+", name = "+name+", testSource = "+testSource+", driver = "+driver+", dataTable = "+dataTable+"]";
    }
	
}
