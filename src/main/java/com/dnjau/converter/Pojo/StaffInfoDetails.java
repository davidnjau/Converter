package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffInfoDetails {

    @JsonProperty("userid_id")
    private String userId;

    @JsonProperty("fullname")
    private String fullName;

    @JsonProperty("employeenum")
    private String employeeNum;

    @JsonProperty("phonenum")
    private String phoneNum;

    @JsonProperty("email")
    private String email;

    public StaffInfoDetails() {
    }

    public StaffInfoDetails(String userId, String fullName, String employeeNum, String phoneNum, String email) {
        this.userId = userId;
        this.fullName = fullName;
        this.employeeNum = employeeNum;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
