package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyProcessDetails {

    @JsonProperty("Re Survey Type")
    private String reSurveyType;

    @JsonProperty("Survey Service Survey Request Actors → Authenticator")
    private String authenticator;

    @JsonProperty("Date Created")
    private String dateCreated;

    @JsonProperty("Number Of Units")
    private String numberOfUnits;

    @JsonProperty("Survey Service Survey Request Actors → Government Surveyor")
    private String governmentSurveyor;

    @JsonProperty("Fr Number")
    private String frNumber;

    @JsonProperty("Reference Number")
    private String referenceNumber;

    @JsonProperty("Survey Service Survey Request Actors → Cartography Sr O")
    private String cartographySrO;

    @JsonProperty("Request Status")
    private String requestStatus;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Land Block Register")
    private String landBlockRegister;

    @JsonProperty("Survey Service Survey Request Actors → Chief Checker")
    private String chiefChecker;

    @JsonProperty("Survey Service Survey Request Actors → Checker")
    private String checker;

    @JsonProperty("Request Type")
    private String requestType;

    @JsonProperty("Survey Service Survey Request Actors → Chief Authenticator")
    private String chiefAuthenticator;

    @JsonProperty("Survey Service Survey Request Actors → Chief Sr O")
    private String chiefSrO;

    @JsonProperty("Land Admin Approval Letter Reference")
    private String landAdminApprovalLetterReference;

    @JsonProperty("Survey Service Survey Request Actors → Dos")
    private String dos;

    @JsonProperty("Licensed Surveyor")
    private String licensedSurveyor;

}
