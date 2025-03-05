package com.dnjau.converter.service_impl.impl;

// Importing required classes


import com.dnjau.converter.Pojo.EmailDetails;
import com.dnjau.converter.helper_class.NotificationStatus;
import com.dnjau.converter.model.Notification;
import com.dnjau.converter.service_impl.service.EmailService;
import com.dnjau.converter.service_impl.service.NotificationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Annotation
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final NotificationService notificationService;

    @Value("${spring.mail.username}") private String sender;

    public EmailServiceImpl(JavaMailSender javaMailSender, NotificationService notificationService) {
        this.javaMailSender = javaMailSender;
        this.notificationService = notificationService;
    }


    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details) {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    // Method 2
    // To send an email with attachment
    @Async
    public void sendMailWithAttachment(
            EmailDetails details,
            byte[] fileBytes,
            String fileName,
            Notification notification) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());

            // Convert byte[] to a temporary file
            File tempFile = File.createTempFile(fileName, ".xlsx");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(fileBytes);
            }

            // Attach the file
            FileSystemResource fileResource = new FileSystemResource(tempFile);
            mimeMessageHelper.addAttachment(fileName, fileResource);

            // Send the email
            javaMailSender.send(mimeMessage);

            notificationService.updateStatus(notification.getId(), NotificationStatus.COMPLETED.name());


            // Clean up: Delete temp file
            tempFile.delete();

        } catch (MessagingException | IOException e) {
            notificationService.updateStatus(notification.getId(), NotificationStatus.FAILED.name());
        }
    }

}
