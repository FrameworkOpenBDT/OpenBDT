package io.openbdt.model;

public class UserStory
{
    private String id;

    private String storyName;

    private String path;

    private String type;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getStoryName ()
    {
        return storyName;
    }

    public void setStoryName (String storyName)
    {
        this.storyName = storyName;
    }

    public String getPath ()
    {
        return path;
    }

    public void setPath (String path)
    {
        this.path = path;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", storyName = "+storyName+", path = "+path+", type = "+type+"]";
    }
}