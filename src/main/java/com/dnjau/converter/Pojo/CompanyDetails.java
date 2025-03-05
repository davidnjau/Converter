package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDetails {

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Kr Ap In")
    private String kraPin;

    @JsonProperty("Name")
    private String fullName;

    @JsonProperty("User ID ID")
    private String userId;

    @JsonProperty("Phone Num")
    private String phoneNumber;

    @JsonProperty("Registration Number")
    private String idNum;

    public CompanyDetails() {
    }

    public CompanyDetails(String email, String kraPin, String fullName, String userId, String phoneNumber, String idNum) {
        this.email = email;
        this.kraPin = kraPin;
        this.fullName = fullName;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.idNum = idNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKraPin() {
        return kraPin;
    }

    public void setKraPin(String kraPin) {
        this.kraPin = kraPin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
}
