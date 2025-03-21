package com.dnjau.converter.service_impl.service;

import com.dnjau.converter.Pojo.NotificationDetails;
import com.dnjau.converter.model.Notification;

import java.util.ArrayList;

public interface NotificationService {
    Notification saveNotification(Notification notification);
    String findById(String id);
    void updateStatus(String id, String status);
    ArrayList<NotificationDetails> findUsingEmail(String email);
    ArrayList<NotificationDetails> findAll();
}
