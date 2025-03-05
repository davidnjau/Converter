package com.dnjau.converter.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "enumerated_parcels")
public class EnumeratedParcels {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "parcel_number", nullable = false)
    private String parcelNumber;

    private String natureOfTitle;
    private String blockName;
    private String approximateArea;
    private String areaUnits;
    private String holdingType;
    private String userId;

    public EnumeratedParcels(String parcelNumber, String natureOfTitle, String blockName, String approximateArea, String areaUnits, String holdingType, String userId) {
        this.parcelNumber = parcelNumber;
        this.natureOfTitle = natureOfTitle;
        this.blockName = blockName;
        this.approximateArea = approximateArea;
        this.areaUnits = areaUnits;
        this.holdingType = holdingType;
        this.userId = userId;
    }

    public EnumeratedParcels() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
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

    public String getApproximateArea() {
        return approximateArea;
    }

    public void setApproximateArea(String approximateArea) {
        this.approximateArea = approximateArea;
    }

    public String getAreaUnits() {
        return areaUnits;
    }

    public void setAreaUnits(String areaUnits) {
        this.areaUnits = areaUnits;
    }

    public String getHoldingType() {
        return holdingType;
    }

    public void setHoldingType(String holdingType) {
        this.holdingType = holdingType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}