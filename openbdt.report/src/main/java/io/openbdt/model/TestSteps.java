package io.openbdt.model;

import java.util.List;

public class TestSteps
{
    private String startTime;

    private String result;

    private String precondition;

    private String duration;

    private List<Screenshots> screenshots;

    private String description;

    private List<Children> children;

    private Integer number;

    public String getStartTime ()
    {
        return startTime;
    }

    public void setStartTime (String startTime)
    {
        this.startTime = startTime;
    }

    public String getResult ()
    {
        return result;
    }

    public void setResult (String result)
    {
        this.result = result;
    }

    public String getPrecondition ()
    {
        return precondition;
    }

    public void setPrecondition (String precondition)
    {
        this.precondition = precondition;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public List<Screenshots> getScreenshots ()
    {
        return screenshots;
    }

    public void setScreenshots (List<Screenshots> screenshots)
    {
        this.screenshots = screenshots;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public List<Children> getChildren ()
    {
        return children;
    }

    public void setChildren (List<Children> children)
    {
        this.children = children;
    }

    public Integer getNumber ()
    {
        return number;
    }

    public void setNumber (Integer number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [startTime = "+startTime+", result = "+result+", precondition = "+precondition+", duration = "+duration+", screenshots = "+screenshots+", description = "+description+", children = "+children+", number = "+number+"]";
    }
}