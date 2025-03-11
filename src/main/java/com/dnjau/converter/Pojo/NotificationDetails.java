package com.dnjau.converter.Pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
