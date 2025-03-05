package com.dnjau.converter.service_impl.service;

import com.dnjau.converter.Pojo.EmailDetails;
import com.dnjau.converter.model.Notification;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details, byte[] fileBytes, String fileName, Notification notification);

}
