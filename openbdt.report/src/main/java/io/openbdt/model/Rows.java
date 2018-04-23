package io.openbdt.model;

public class Rows
{
    private String result;

    private String[] values;

    public String getResult ()
    {
        return result;
    }

    public void setResult (String result)
    {
        this.result = result;
    }

    public String[] getValues ()
    {
        return values;
    }

    public void setValues (String[] values)
    {
        this.values = values;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+", values = "+values+"]";
    }
}