package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
