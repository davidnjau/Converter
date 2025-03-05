package com.dnjau.converter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public_users")
public class PublicUsers {

    @Id
    private String userId;
    private String phoneNumber;
    private String emailAddress;
    private String fullName;
    private String kraPin;
    private String userType;


    public PublicUsers(String userId, String phoneNumber, String emailAddress, String fullName, String kraPin, String userType) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.kraPin = kraPin;
        this.userType = userType;
    }

    public PublicUsers() {
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getKraPin() {
        return kraPin;
    }

    public void setKraPin(String kraPin) {
        this.kraPin = kraPin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}