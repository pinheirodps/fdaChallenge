
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
 * The type Openfda dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "application_number",
    "brand_name",
    "generic_name",
    "manufacturer_name",
    "product_ndc",
    "product_type",
    "route",
    "substance_name",
    "rxcui",
    "spl_id",
    "spl_set_id",
    "package_ndc",
    "unii"
})
@Builder
public class OpenfdaDto {

    @JsonProperty("application_number")
    private List<String> applicationNumber = null;
    @JsonProperty("brand_name")
    private List<String> brandName = null;
    @JsonProperty("generic_name")
    private List<String> genericName = null;
    @JsonProperty("manufacturer_name")
    private List<String> manufacturerName = null;
    @JsonProperty("product_ndc")
    private List<String> productNdc = null;
    @JsonProperty("product_type")
    private List<String> productType = null;
    @JsonProperty("route")
    private List<String> route = null;
    @JsonProperty("substance_name")
    private List<String> substanceName = null;
    @JsonProperty("rxcui")
    private List<String> rxcui = null;
    @JsonProperty("spl_id")
    private List<String> splId = null;
    @JsonProperty("spl_set_id")
    private List<String> splSetId = null;
    @JsonProperty("package_ndc")
    private List<String> packageNdc = null;
    @JsonProperty("unii")
    private List<String> unii = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Gets application number.
     *
     * @return the application number
     */
    @JsonProperty("application_number")
    public List<String> getApplicationNumber() {
        return applicationNumber;
    }

    /**
     * Sets application number.
     *
     * @param applicationNumber the application number
     */
    @JsonProperty("application_number")
    public void setApplicationNumber(List<String> applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    /**
     * Gets brand name.
     *
     * @return the brand name
     */
    @JsonProperty("brand_name")
    public List<String> getBrandName() {
        return brandName;
    }

    /**
     * Sets brand name.
     *
     * @param brandName the brand name
     */
    @JsonProperty("brand_name")
    public void setBrandName(List<String> brandName) {
        this.brandName = brandName;
    }

    /**
     * Gets generic name.
     *
     * @return the generic name
     */
    @JsonProperty("generic_name")
    public List<String> getGenericName() {
        return genericName;
    }

    /**
     * Sets generic name.
     *
     * @param genericName the generic name
     */
    @JsonProperty("generic_name")
    public void setGenericName(List<String> genericName) {
        this.genericName = genericName;
    }

    /**
     * Gets manufacturer name.
     *
     * @return the manufacturer name
     */
    @JsonProperty("manufacturer_name")
    public List<String> getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Sets manufacturer name.
     *
     * @param manufacturerName the manufacturer name
     */
    @JsonProperty("manufacturer_name")
    public void setManufacturerName(List<String> manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    /**
     * Gets product ndc.
     *
     * @return the product ndc
     */
    @JsonProperty("product_ndc")
    public List<String> getProductNdc() {
        return productNdc;
    }

    /**
     * Sets product ndc.
     *
     * @param productNdc the product ndc
     */
    @JsonProperty("product_ndc")
    public void setProductNdc(List<String> productNdc) {
        this.productNdc = productNdc;
    }

    /**
     * Gets product type.
     *
     * @return the product type
     */
    @JsonProperty("product_type")
    public List<String> getProductType() {
        return productType;
    }

    /**
     * Sets product type.
     *
     * @param productType the product type
     */
    @JsonProperty("product_type")
    public void setProductType(List<String> productType) {
        this.productType = productType;
    }

    /**
     * Gets route.
     *
     * @return the route
     */
    @JsonProperty("route")
    public List<String> getRoute() {
        return route;
    }

    /**
     * Sets route.
     *
     * @param route the route
     */
    @JsonProperty("route")
    public void setRoute(List<String> route) {
        this.route = route;
    }

    /**
     * Gets substance name.
     *
     * @return the substance name
     */
    @JsonProperty("substance_name")
    public List<String> getSubstanceName() {
        return substanceName;
    }

    /**
     * Sets substance name.
     *
     * @param substanceName the substance name
     */
    @JsonProperty("substance_name")
    public void setSubstanceName(List<String> substanceName) {
        this.substanceName = substanceName;
    }

    /**
     * Gets rxcui.
     *
     * @return the rxcui
     */
    @JsonProperty("rxcui")
    public List<String> getRxcui() {
        return rxcui;
    }

    /**
     * Sets rxcui.
     *
     * @param rxcui the rxcui
     */
    @JsonProperty("rxcui")
    public void setRxcui(List<String> rxcui) {
        this.rxcui = rxcui;
    }

    /**
     * Gets spl id.
     *
     * @return the spl id
     */
    @JsonProperty("spl_id")
    public List<String> getSplId() {
        return splId;
    }

    /**
     * Sets spl id.
     *
     * @param splId the spl id
     */
    @JsonProperty("spl_id")
    public void setSplId(List<String> splId) {
        this.splId = splId;
    }

    /**
     * Gets spl set id.
     *
     * @return the spl set id
     */
    @JsonProperty("spl_set_id")
    public List<String> getSplSetId() {
        return splSetId;
    }

    /**
     * Sets spl set id.
     *
     * @param splSetId the spl set id
     */
    @JsonProperty("spl_set_id")
    public void setSplSetId(List<String> splSetId) {
        this.splSetId = splSetId;
    }

    /**
     * Gets package ndc.
     *
     * @return the package ndc
     */
    @JsonProperty("package_ndc")
    public List<String> getPackageNdc() {
        return packageNdc;
    }

    /**
     * Sets package ndc.
     *
     * @param packageNdc the package ndc
     */
    @JsonProperty("package_ndc")
    public void setPackageNdc(List<String> packageNdc) {
        this.packageNdc = packageNdc;
    }

    /**
     * Gets unii.
     *
     * @return the unii
     */
    @JsonProperty("unii")
    public List<String> getUnii() {
        return unii;
    }

    /**
     * Sets unii.
     *
     * @param unii the unii
     */
    @JsonProperty("unii")
    public void setUnii(List<String> unii) {
        this.unii = unii;
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
