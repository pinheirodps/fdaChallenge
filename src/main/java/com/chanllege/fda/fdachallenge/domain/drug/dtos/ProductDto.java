
package com.chanllege.fda.fdachallenge.domain.drug.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Product dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "product_number",
    "reference_drug",
    "brand_name",
    "active_ingredients",
    "reference_standard",
    "dosage_form",
    "route",
    "marketing_status",
    "te_code"
})
@Builder
public class ProductDto {

    @JsonProperty("product_number")
    private String productNumber;
    @JsonProperty("reference_drug")
    private String referenceDrug;
    @JsonProperty("brand_name")
    private String brandName;
    @JsonProperty("active_ingredients")
    private List<ActiveIngredientDto> activeIngredients = null;
    @JsonProperty("reference_standard")
    private String referenceStandard;
    @JsonProperty("dosage_form")
    private String dosageForm;
    @JsonProperty("route")
    private String route;
    @JsonProperty("marketing_status")
    private String marketingStatus;
    @JsonProperty("te_code")
    private String teCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Gets product number.
     *
     * @return the product number
     */
    @JsonProperty("product_number")
    public String getProductNumber() {
        return productNumber;
    }

    /**
     * Sets product number.
     *
     * @param productNumber the product number
     */
    @JsonProperty("product_number")
    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    /**
     * Gets reference drug.
     *
     * @return the reference drug
     */
    @JsonProperty("reference_drug")
    public String getReferenceDrug() {
        return referenceDrug;
    }

    /**
     * Sets reference drug.
     *
     * @param referenceDrug the reference drug
     */
    @JsonProperty("reference_drug")
    public void setReferenceDrug(String referenceDrug) {
        this.referenceDrug = referenceDrug;
    }

    /**
     * Gets brand name.
     *
     * @return the brand name
     */
    @JsonProperty("brand_name")
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets brand name.
     *
     * @param brandName the brand name
     */
    @JsonProperty("brand_name")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Gets active ingredients.
     *
     * @return the active ingredients
     */
    @JsonProperty("active_ingredients")
    public List<ActiveIngredientDto> getActiveIngredients() {
        return activeIngredients;
    }

    /**
     * Sets active ingredients.
     *
     * @param activeIngredients the active ingredients
     */
    @JsonProperty("active_ingredients")
    public void setActiveIngredients(List<ActiveIngredientDto> activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    /**
     * Gets reference standard.
     *
     * @return the reference standard
     */
    @JsonProperty("reference_standard")
    public String getReferenceStandard() {
        return referenceStandard;
    }

    /**
     * Sets reference standard.
     *
     * @param referenceStandard the reference standard
     */
    @JsonProperty("reference_standard")
    public void setReferenceStandard(String referenceStandard) {
        this.referenceStandard = referenceStandard;
    }

    /**
     * Gets dosage form.
     *
     * @return the dosage form
     */
    @JsonProperty("dosage_form")
    public String getDosageForm() {
        return dosageForm;
    }

    /**
     * Sets dosage form.
     *
     * @param dosageForm the dosage form
     */
    @JsonProperty("dosage_form")
    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    /**
     * Gets route.
     *
     * @return the route
     */
    @JsonProperty("route")
    public String getRoute() {
        return route;
    }

    /**
     * Sets route.
     *
     * @param route the route
     */
    @JsonProperty("route")
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * Gets marketing status.
     *
     * @return the marketing status
     */
    @JsonProperty("marketing_status")
    public String getMarketingStatus() {
        return marketingStatus;
    }

    /**
     * Sets marketing status.
     *
     * @param marketingStatus the marketing status
     */
    @JsonProperty("marketing_status")
    public void setMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
    }

    /**
     * Gets te code.
     *
     * @return the te code
     */
    @JsonProperty("te_code")
    public String getTeCode() {
        return teCode;
    }

    /**
     * Sets te code.
     *
     * @param teCode the te code
     */
    @JsonProperty("te_code")
    public void setTeCode(String teCode) {
        this.teCode = teCode;
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
