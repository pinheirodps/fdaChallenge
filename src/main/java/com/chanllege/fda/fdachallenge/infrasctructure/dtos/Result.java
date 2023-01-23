
package com.chanllege.fda.fdachallenge.infrasctructure.dtos;

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
 * The type Result.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "submissions",
    "application_number",
    "sponsor_name",
    "openfda",
    "products"
})
public class Result {

    @JsonProperty("submissions")
    private List<Submission> submissions = null;
    @JsonProperty("application_number")
    private String applicationNumber;
    @JsonProperty("sponsor_name")
    private String sponsorName;
    @JsonProperty("openfda")
    private Openfda openfda;
    @JsonProperty("products")
    private List<Product> products = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Gets submissions.
     *
     * @return the submissions
     */
    @JsonProperty("submissions")
    public List<Submission> getSubmissions() {
        return submissions;
    }

    /**
     * Sets submissions.
     *
     * @param submissions the submissions
     */
    @JsonProperty("submissions")
    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    /**
     * Gets application number.
     *
     * @return the application number
     */
    @JsonProperty("application_number")
    public String getApplicationNumber() {
        return applicationNumber;
    }

    /**
     * Sets application number.
     *
     * @param applicationNumber the application number
     */
    @JsonProperty("application_number")
    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    /**
     * Gets sponsor name.
     *
     * @return the sponsor name
     */
    @JsonProperty("sponsor_name")
    public String getSponsorName() {
        return sponsorName;
    }

    /**
     * Sets sponsor name.
     *
     * @param sponsorName the sponsor name
     */
    @JsonProperty("sponsor_name")
    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    /**
     * Gets openfda.
     *
     * @return the openfda
     */
    @JsonProperty("openfda")
    public Openfda getOpenfda() {
        return openfda;
    }

    /**
     * Sets openfda.
     *
     * @param openfda the openfda
     */
    @JsonProperty("openfda")
    public void setOpenfda(Openfda openfda) {
        this.openfda = openfda;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    @JsonProperty("products")
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    @JsonProperty("products")
    public void setProducts(List<Product> products) {
        this.products = products;
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
