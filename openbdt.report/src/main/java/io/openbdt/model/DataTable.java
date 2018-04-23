package io.openbdt.model;

import java.util.List;

public class DataTable
{
    private String[] headers;

    private String scenarioOutline;

    private String predefinedRows;

    private DataSetDescriptors[] dataSetDescriptors;

    private List<Rows> rows;

    public String[] getHeaders ()
    {
        return headers;
    }

    public void setHeaders (String[] headers)
    {
        this.headers = headers;
    }

    public String getScenarioOutline ()
    {
        return scenarioOutline;
    }

    public void setScenarioOutline (String scenarioOutline)
    {
        this.scenarioOutline = scenarioOutline;
    }

    public String getPredefinedRows ()
    {
        return predefinedRows;
    }

    public void setPredefinedRows (String predefinedRows)
    {
        this.predefinedRows = predefinedRows;
    }

    public DataSetDescriptors[] getDataSetDescriptors ()
    {
        return dataSetDescriptors;
    }

    public void setDataSetDescriptors (DataSetDescriptors[] dataSetDescriptors)
    {
        this.dataSetDescriptors = dataSetDescriptors;
    }

    public List<Rows> getRows ()
    {
        return rows;
    }

    public void setRows (List<Rows> rows)
    {
        this.rows = rows;
    }

}
