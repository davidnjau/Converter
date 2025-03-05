package com.dnjau.converter.repository;

import com.dnjau.converter.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, String> {
}