package com.dnjau.converter.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
