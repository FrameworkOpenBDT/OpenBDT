
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
    "number",
    "description",
    "duration",
    "startTime",
    "screenshots",
    "result",
    "precondition",
    "children"
})
public class TestStep {

    @JsonProperty("number")
    private Integer number;
    @JsonProperty("description")
    private String description;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("screenshots")
    private List<Screenshot> screenshots = null;
    @JsonProperty("result")
    private String result;
    @JsonProperty("precondition")
    private Boolean precondition;
    @JsonProperty("children")
    private List<Child> children = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("screenshots")
    public List<Screenshot> getScreenshots() {
        return screenshots;
    }

    @JsonProperty("screenshots")
    public void setScreenshots(List<Screenshot> screenshots) {
        this.screenshots = screenshots;
    }

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    @JsonProperty("precondition")
    public Boolean getPrecondition() {
        return precondition;
    }

    @JsonProperty("precondition")
    public void setPrecondition(Boolean precondition) {
        this.precondition = precondition;
    }

    @JsonProperty("children")
    public List<Child> getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(List<Child> children) {
        this.children = children;
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
