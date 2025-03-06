package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyProcessDetails {

    @JsonProperty("Reference Number")
    private String referenceNumber;

    @JsonProperty("Request Type")
    private String requestType;

    @JsonProperty("Re Survey Type")
    private String reSurveyType;

    @JsonProperty("Date Created")
    private String dateCreated;

    @JsonProperty("Licensed Surveyor")
    private String licensedSurveyor;

    @JsonProperty("Survey Service Survey Request Actors → Authenticator")
    private String authenticator;

    @JsonProperty("Survey Service Survey Request Actors → Government Surveyor")
    private String governmentSurveyor;

    @JsonProperty("Survey Service Survey Request Actors → Cartography Sr O")
    private String cartographySrO;

    @JsonProperty("Survey Service Survey Request Actors → Chief Checker")
    private String chiefChecker;

    @JsonProperty("Survey Service Survey Request Actors → Checker")
    private String checker;

    @JsonProperty("Survey Service Survey Request Actors → Chief Authenticator")
    private String chiefAuthenticator;

    @JsonProperty("Survey Service Survey Request Actors → Chief Sr O")
    private String chiefSrO;

    @JsonProperty("Survey Service Survey Request Actors → Dos")
    private String dos;

//    Not compulsory
    @JsonProperty("Number Of Units")
    private String numberOfUnits;

    @JsonProperty("Fr Number")
    private String frNumber;

   @JsonProperty("Request Status")
    private String requestStatus;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Land Block Register")
    private String landBlockRegister;

    @JsonProperty("Land Admin Approval Letter Reference")
    private String landAdminApprovalLetterReference;

    public SurveyProcessDetails(String referenceNumber, String requestType, String reSurveyType,
                                String dateCreated,
                                String licensedSurveyor, String authenticator, String governmentSurveyor,
                                String cartographySrO, String chiefChecker, String checker, String chiefAuthenticator,
                                String chiefSrO, String dos) {
        this.referenceNumber = referenceNumber;
        this.requestType = requestType;
        this.reSurveyType = reSurveyType;
        this.dateCreated = dateCreated;
        this.licensedSurveyor = licensedSurveyor;
        this.authenticator = authenticator;
        this.governmentSurveyor = governmentSurveyor;
        this.cartographySrO = cartographySrO;
        this.chiefChecker = chiefChecker;
        this.checker = checker;
        this.chiefAuthenticator = chiefAuthenticator;
        this.chiefSrO = chiefSrO;
        this.dos = dos;
    }

    public SurveyProcessDetails() {
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getReSurveyType() {
        return reSurveyType;
    }

    public void setReSurveyType(String reSurveyType) {
        this.reSurveyType = reSurveyType;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLicensedSurveyor() {
        return licensedSurveyor;
    }

    public void setLicensedSurveyor(String licensedSurveyor) {
        this.licensedSurveyor = licensedSurveyor;
    }

    public String getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(String authenticator) {
        this.authenticator = authenticator;
    }

    public String getGovernmentSurveyor() {
        return governmentSurveyor;
    }

    public void setGovernmentSurveyor(String governmentSurveyor) {
        this.governmentSurveyor = governmentSurveyor;
    }

    public String getCartographySrO() {
        return cartographySrO;
    }

    public void setCartographySrO(String cartographySrO) {
        this.cartographySrO = cartographySrO;
    }

    public String getChiefChecker() {
        return chiefChecker;
    }

    public void setChiefChecker(String chiefChecker) {
        this.chiefChecker = chiefChecker;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getChiefAuthenticator() {
        return chiefAuthenticator;
    }

    public void setChiefAuthenticator(String chiefAuthenticator) {
        this.chiefAuthenticator = chiefAuthenticator;
    }

    public String getChiefSrO() {
        return chiefSrO;
    }

    public void setChiefSrO(String chiefSrO) {
        this.chiefSrO = chiefSrO;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(String numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public String getFrNumber() {
        return frNumber;
    }

    public void setFrNumber(String frNumber) {
        this.frNumber = frNumber;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandBlockRegister() {
        return landBlockRegister;
    }

    public void setLandBlockRegister(String landBlockRegister) {
        this.landBlockRegister = landBlockRegister;
    }

    public String getLandAdminApprovalLetterReference() {
        return landAdminApprovalLetterReference;
    }

    public void setLandAdminApprovalLetterReference(String landAdminApprovalLetterReference) {
        this.landAdminApprovalLetterReference = landAdminApprovalLetterReference;
    }
}
