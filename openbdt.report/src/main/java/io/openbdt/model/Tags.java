package io.openbdt.model;

public class Tags
{
    private String name;

    private String type;

    public Tags() {}
    
    public Tags(String name, String type) {
    	this.name = name;
    	this.type = type;
    }
    
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
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
        return "ClassPojo [name = "+name+", type = "+type+"]";
    }
}