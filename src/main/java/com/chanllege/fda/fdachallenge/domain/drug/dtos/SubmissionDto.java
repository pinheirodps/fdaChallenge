
package com.chanllege.fda.fdachallenge.domain.drug.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Submission dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "submission_type",
    "submission_number",
    "submission_status",
    "submission_status_date",
    "review_priority",
    "submission_class_code",
    "submission_class_code_description",
    "application_docs"
})
public class SubmissionDto {

    @JsonProperty("submission_type")
    private String submissionType;
    @JsonProperty("submission_number")
    private String submissionNumber;
    @JsonProperty("submission_status")
    private String submissionStatus;
    @JsonProperty("submission_status_date")
    private String submissionStatusDate;
    @JsonProperty("review_priority")
    private String reviewPriority;
    @JsonProperty("submission_class_code")
    private String submissionClassCode;
    @JsonProperty("submission_class_code_description")
    private String submissionClassCodeDescription;
    @JsonProperty("application_docs")
    private List<ApplicationDocDto> applicationDocs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Gets submission type.
     *
     * @return the submission type
     */
    @JsonProperty("submission_type")
    public String getSubmissionType() {
        return submissionType;
    }

    /**
     * Sets submission type.
     *
     * @param submissionType the submission type
     */
    @JsonProperty("submission_type")
    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }

    /**
     * Gets submission number.
     *
     * @return the submission number
     */
    @JsonProperty("submission_number")
    public String getSubmissionNumber() {
        return submissionNumber;
    }

    /**
     * Sets submission number.
     *
     * @param submissionNumber the submission number
     */
    @JsonProperty("submission_number")
    public void setSubmissionNumber(String submissionNumber) {
        this.submissionNumber = submissionNumber;
    }

    /**
     * Gets submission status.
     *
     * @return the submission status
     */
    @JsonProperty("submission_status")
    public String getSubmissionStatus() {
        return submissionStatus;
    }

    /**
     * Sets submission status.
     *
     * @param submissionStatus the submission status
     */
    @JsonProperty("submission_status")
    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    /**
     * Gets submission status date.
     *
     * @return the submission status date
     */
    @JsonProperty("submission_status_date")
    public String getSubmissionStatusDate() {
        return submissionStatusDate;
    }

    /**
     * Sets submission status date.
     *
     * @param submissionStatusDate the submission status date
     */
    @JsonProperty("submission_status_date")
    public void setSubmissionStatusDate(String submissionStatusDate) {
        this.submissionStatusDate = submissionStatusDate;
    }

    /**
     * Gets review priority.
     *
     * @return the review priority
     */
    @JsonProperty("review_priority")
    public String getReviewPriority() {
        return reviewPriority;
    }

    /**
     * Sets review priority.
     *
     * @param reviewPriority the review priority
     */
    @JsonProperty("review_priority")
    public void setReviewPriority(String reviewPriority) {
        this.reviewPriority = reviewPriority;
    }

    /**
     * Gets submission class code.
     *
     * @return the submission class code
     */
    @JsonProperty("submission_class_code")
    public String getSubmissionClassCode() {
        return submissionClassCode;
    }

    /**
     * Sets submission class code.
     *
     * @param submissionClassCode the submission class code
     */
    @JsonProperty("submission_class_code")
    public void setSubmissionClassCode(String submissionClassCode) {
        this.submissionClassCode = submissionClassCode;
    }

    /**
     * Gets submission class code description.
     *
     * @return the submission class code description
     */
    @JsonProperty("submission_class_code_description")
    public String getSubmissionClassCodeDescription() {
        return submissionClassCodeDescription;
    }

    /**
     * Sets submission class code description.
     *
     * @param submissionClassCodeDescription the submission class code description
     */
    @JsonProperty("submission_class_code_description")
    public void setSubmissionClassCodeDescription(String submissionClassCodeDescription) {
        this.submissionClassCodeDescription = submissionClassCodeDescription;
    }

    /**
     * Gets application docs.
     *
     * @return the application docs
     */
    @JsonProperty("application_docs")
    public List<ApplicationDocDto> getApplicationDocs() {
        return applicationDocs;
    }

    /**
     * Sets application docs.
     *
     * @param applicationDocs the application docs
     */
    @JsonProperty("application_docs")
    public void setApplicationDocs(List<ApplicationDocDto> applicationDocs) {
        this.applicationDocs = applicationDocs;
    }

    /**
     * Gets additional properties.
     *
     * @return the additional properties
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Sets additional property.
     *
     * @param name  the name
     * @param value the value
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
