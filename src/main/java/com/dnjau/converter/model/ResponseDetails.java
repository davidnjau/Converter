package com.dnjau.converter.model;

public class ResponseDetails {
    private String message;

    public ResponseDetails() {
    }
    public ResponseDetails(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
