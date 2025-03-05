package com.dnjau.converter.service_impl.service;

import com.dnjau.converter.Pojo.EmailDetails;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details, byte[] fileBytes, String fileName);

}
