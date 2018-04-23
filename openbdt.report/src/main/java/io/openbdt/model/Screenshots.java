package io.openbdt.model;

public class Screenshots
{
    private String screenshot;

    public String getScreenshot ()
    {
        return screenshot;
    }

    public void setScreenshot (String screenshot)
    {
        this.screenshot = screenshot;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [screenshot = "+screenshot+"]";
    }
}