
package io.openbdt.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "headers",
    "rows",
    "predefinedRows",
    "dataSetDescriptors"
})
public class DataTable {

    @JsonProperty("headers")
    private List<String> headers = null;
    @JsonProperty("rows")
    private List<Row> rows = null;
    @JsonProperty("predefinedRows")
    private Boolean predefinedRows;
    @JsonProperty("dataSetDescriptors")
    private List<DataSetDescriptor> dataSetDescriptors = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("headers")
    public List<String> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    @JsonProperty("rows")
    public List<Row> getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @JsonProperty("predefinedRows")
    public Boolean getPredefinedRows() {
        return predefinedRows;
    }

    @JsonProperty("predefinedRows")
    public void setPredefinedRows(Boolean predefinedRows) {
        this.predefinedRows = predefinedRows;
    }

    @JsonProperty("dataSetDescriptors")
    public List<DataSetDescriptor> getDataSetDescriptors() {
        return dataSetDescriptors;
    }

    @JsonProperty("dataSetDescriptors")
    public void setDataSetDescriptors(List<DataSetDescriptor> dataSetDescriptors) {
        this.dataSetDescriptors = dataSetDescriptors;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
