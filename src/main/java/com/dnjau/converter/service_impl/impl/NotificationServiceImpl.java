package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.Pojo.NotificationDetails;
import com.dnjau.converter.model.Notification;
import com.dnjau.converter.repository.NotificationRepository;
import com.dnjau.converter.service_impl.service.NotificationService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        return "The status of the process" + " is: " + status.toLowerCase();

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



    @Override
    public ArrayList<NotificationDetails> findUsingEmail(String email) {

        ArrayList<Notification> notificationList = notificationRepository.findNotificationByUserInfo(email);
        notificationList.removeIf(notification -> notification.getCreatedAt() == null);

        ArrayList<NotificationDetails> notificationDetailsList = new ArrayList<>();
        for (Notification notification : notificationList) {

            NotificationDetails notificationDetails = new NotificationDetails(
                    notification.getId(),
                    notification.getStatus().toLowerCase(),
                    String.valueOf(notification.getCreatedAt()),
                    notification.getUserInfo(),
                    notification.getMessage(),
                    getTimeElapsed(notification)
            );
            notificationDetailsList.add(notificationDetails);

        }

        //Sort the list by createdAt in descending order
        notificationDetailsList.sort((o1, o2) -> o2.getCreatedAt().compareTo(o1.getCreatedAt()));

        return notificationDetailsList;

    }

    //Create a method to get the Time elapsed since the notification was created based on the createdAt
    public String getTimeElapsed(Notification notification) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - notification.getCreatedAt().getTime();

        //Convert milliseconds to seconds
        long secondsElapsed = timeElapsed / 1000;

        //Convert seconds to minutes
        long minutesElapsed = secondsElapsed / 60;

        //Convert minutes to hours
        long hoursElapsed = minutesElapsed / 60;

        //Convert hours to days
        long daysElapsed = hoursElapsed / 24;

        //Return the time elapsed in a readable format
        return String.format("%d days, %d hours, %d minutes", daysElapsed, hoursElapsed % 24, minutesElapsed % 60);
    }

    @Override
    public ArrayList<NotificationDetails> findAll() {
        ArrayList<Notification> notificationList = new ArrayList<>(notificationRepository.findAll());

        notificationList.removeIf(notification -> notification.getCreatedAt() == null);

        ArrayList<NotificationDetails> notificationDetailsList = new ArrayList<>();
        for (Notification notification : notificationList) {

            NotificationDetails notificationDetails = new NotificationDetails(
                    notification.getId(),
                    notification.getStatus().toLowerCase(),
                    String.valueOf(notification.getCreatedAt()),
                    notification.getUserInfo(),
                    notification.getMessage(),
                    getTimeElapsed(notification)
            );
            notificationDetailsList.add(notificationDetails);

        }

        //Sort the list by createdAt in descending order
        notificationDetailsList.sort((o1, o2) -> o2.getCreatedAt().compareTo(o1.getCreatedAt()));

        return notificationDetailsList;


    }
}
