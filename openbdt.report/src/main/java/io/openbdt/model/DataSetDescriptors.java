package io.openbdt.model;

public class DataSetDescriptors
{
    private String startRow;

    private String name;

    private String rowCount;

    public String getStartRow ()
    {
        return startRow;
    }

    public void setStartRow (String startRow)
    {
        this.startRow = startRow;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getRowCount ()
    {
        return rowCount;
    }

    public void setRowCount (String rowCount)
    {
        this.rowCount = rowCount;
    }
}