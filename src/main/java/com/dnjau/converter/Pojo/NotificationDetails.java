package com.dnjau.converter.Pojo;

public class NotificationDetails {
    private String id;
    private String status;
    private String createdAt;
    private String userInfo;
    private String message;
    private String timeElapsed;

    public NotificationDetails() {
    }

    public NotificationDetails(String id, String status, String createdAt, String userInfo, String message, String timeElapsed) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.userInfo = userInfo;
        this.message = message;
        this.timeElapsed = timeElapsed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
