package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDetails {

    @JsonProperty("holding_type")
    private String holdingType;

    @JsonProperty("approximate_area")
    private String approximateArea;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("block_number")
    private String blockNumber;

    @JsonProperty("registration_property_number")
    private String registrationPropertyNumber;

    @JsonProperty("property_number")
    private String propertyNumber;

    @JsonProperty("area_units")
    private String areaUnits;

    @JsonProperty("nature_of_title")
    private String natureOfTitle;

    @JsonProperty("block_name")
    private String blockName;

    // Getters and Setters
    public String getHoldingType() {
        return holdingType;
    }

    public void setHoldingType(String holdingType) {
        this.holdingType = holdingType;
    }

    public String getApproximateArea() {
        return approximateArea;
    }

    public void setApproximateArea(String approximateArea) {
        this.approximateArea = approximateArea;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getRegistrationPropertyNumber() {
        return registrationPropertyNumber;
    }

    public void setRegistrationPropertyNumber(String registrationPropertyNumber) {
        this.registrationPropertyNumber = registrationPropertyNumber;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getAreaUnits() {
        return areaUnits;
    }

    public void setAreaUnits(String areaUnits) {
        this.areaUnits = areaUnits;
    }

    public String getNatureOfTitle() {
        return natureOfTitle;
    }

    public void setNatureOfTitle(String natureOfTitle) {
        this.natureOfTitle = natureOfTitle;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}

