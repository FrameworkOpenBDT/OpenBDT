package io.openbdt.model;

import java.util.List;

public class Children
{
    private String startTime;

    private String result;

    private String precondition;

    private String duration;

    private List<Screenshots> screenshots;

    private String description;

    private String number;

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

    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [startTime = "+startTime+", result = "+result+", precondition = "+precondition+", duration = "+duration+", screenshots = "+screenshots+", description = "+description+", number = "+number+"]";
    }
}
