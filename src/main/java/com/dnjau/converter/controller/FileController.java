package com.dnjau.converter.controller;

import com.dnjau.converter.helper_class.NotificationStatus;
import com.dnjau.converter.model.Notification;
import com.dnjau.converter.model.ResponseDetails;
import com.dnjau.converter.service_impl.service.FileProcessingService;
import com.dnjau.converter.service_impl.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/json/api/v1/")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileProcessingService fileProcessingService;
    private final NotificationService notificationService;

    @RequestMapping(value = "import", method = RequestMethod.POST)
    public ResponseEntity<ResponseDetails> processJson(@RequestParam("file") MultipartFile file) throws IOException {

        Notification notification = new Notification();
        notification.setStatus(NotificationStatus.PENDING.name());
        notification = notificationService.saveNotification(notification);

        fileProcessingService.processFile(file, notification);
        return ResponseEntity.ok(new ResponseDetails("File processing started in the background. " +
                "Use the following link to check the status. \n " +
                "http://localhost:7001/data/api/v1/notification/ " + notification.getId()));
    }


}
