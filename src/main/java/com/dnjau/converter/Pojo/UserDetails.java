package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Kr Ap In")
    private String krApIn;

    @JsonProperty("Full Name")
    private String fullName;

    @JsonProperty("User ID ID")
    private String userId;

    @JsonProperty("Phone Num")
    private String phoneNum;

    @JsonProperty("ID Num")
    private String idNum;

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKrApIn() {
        return krApIn;
    }

    public void setKrApIn(String krApIn) {
        this.krApIn = krApIn;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
}

