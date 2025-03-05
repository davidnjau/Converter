package com.dnjau.converter.service_impl.service;

import com.dnjau.converter.model.Notification;

public interface NotificationService {
    Notification saveNotification(Notification notification);
    String findById(String id);
    void updateStatus(String id, String status);
}
