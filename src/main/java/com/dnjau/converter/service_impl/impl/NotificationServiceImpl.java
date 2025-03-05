package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.model.Notification;
import com.dnjau.converter.repository.NotificationRepository;
import com.dnjau.converter.service_impl.service.NotificationService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public String findById(String id) {

        Optional<Notification> optionalNotification = notificationRepository.findById(id);
        if (optionalNotification.isEmpty()){
            return "The requested notification could not be found";
        }
        Notification notification = optionalNotification.get();
        String status = notification.getStatus();
        return "The status of the notification" + " is: " + status.toLowerCase();

    }

    @Override
    public void updateStatus(String id, String status) {

        log.info("Updating status of notification with id: {} to: {}", id, status);

        notificationRepository.findById(id)
                .map(notificationOld -> {
                    notificationOld.setStatus(status);
                    return notificationRepository.save(notificationOld);
                }).orElse(null);


    }
}
