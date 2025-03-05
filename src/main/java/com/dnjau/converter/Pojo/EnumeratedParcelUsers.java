package com.dnjau.converter.Pojo;

public class EnumeratedParcelUsers {

    private String propertyNumber;
    private String holdingType;
    private String approximateArea;
    private String areaUnits;
    private String natureOfTitle;

    private String fullName;
    private String phoneNumber;
    private String emailAddress;
    private String kraPin;

    public EnumeratedParcelUsers() {
    }

    public EnumeratedParcelUsers(String propertyNumber, String holdingType, String approximateArea, String areaUnits, String natureOfTitle, String fullName, String phoneNumber, String emailAddress, String kraPin) {
        this.propertyNumber = propertyNumber;
        this.holdingType = holdingType;
        this.approximateArea = approximateArea;
        this.areaUnits = areaUnits;
        this.natureOfTitle = natureOfTitle;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.kraPin = kraPin;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getKraPin() {
        return kraPin;
    }

    public void setKraPin(String kraPin) {
        this.kraPin = kraPin;
    }
}
