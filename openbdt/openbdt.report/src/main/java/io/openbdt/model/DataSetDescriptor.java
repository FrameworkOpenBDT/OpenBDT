
package io.openbdt.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startRow",
    "rowCount",
    "name",
    "description"
})
public class DataSetDescriptor {

    @JsonProperty("startRow")
    private Integer startRow;
    @JsonProperty("rowCount")
    private Integer rowCount;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("startRow")
    public Integer getStartRow() {
        return startRow;
    }

    @JsonProperty("startRow")
    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    @JsonProperty("rowCount")
    public Integer getRowCount() {
        return rowCount;
    }

    @JsonProperty("rowCount")
    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
