
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
    "declaringClass",
    "methodName",
    "fileName",
    "lineNumber"
})
public class StackTrace_ {

    @JsonProperty("declaringClass")
    private String declaringClass;
    @JsonProperty("methodName")
    private String methodName;
    @JsonProperty("fileName")
    private String fileName;
    @JsonProperty("lineNumber")
    private Integer lineNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("declaringClass")
    public String getDeclaringClass() {
        return declaringClass;
    }

    @JsonProperty("declaringClass")
    public void setDeclaringClass(String declaringClass) {
        this.declaringClass = declaringClass;
    }

    @JsonProperty("methodName")
    public String getMethodName() {
        return methodName;
    }

    @JsonProperty("methodName")
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @JsonProperty("fileName")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @JsonProperty("lineNumber")
    public Integer getLineNumber() {
        return lineNumber;
    }

    @JsonProperty("lineNumber")
    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
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
