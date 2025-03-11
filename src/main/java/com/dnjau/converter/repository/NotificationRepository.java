package com.dnjau.converter.repository;

import com.dnjau.converter.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    ArrayList<Notification> findNotificationByUserInfo(String email);
}