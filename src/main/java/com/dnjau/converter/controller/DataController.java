package com.dnjau.converter.controller;

import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.Pojo.UserDetails;
import com.dnjau.converter.helper_class.NotificationStatus;
import com.dnjau.converter.model.Notification;
import com.dnjau.converter.model.PublicUsers;
import com.dnjau.converter.model.ResponseDetails;
import com.dnjau.converter.service_impl.impl.FileProcessingServiceImpl;
import com.dnjau.converter.service_impl.service.ExcelService;
import com.dnjau.converter.service_impl.service.NotificationService;
import com.dnjau.converter.service_impl.service.PublicUserService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/data/api/v1/")
@RequiredArgsConstructor
public class DataController {

    private final FileProcessingServiceImpl fileProcessingService;
    private final PublicUserService publicUserService;
    private final ExcelService excelService;
    private final NotificationService notificationService;

    @GetMapping("properties")
    public ResponseEntity<List<PropertyDetails>> getPropertyDetails() {
        return ResponseEntity.ok(fileProcessingService.getPropertyDetailsList());
    }

    @GetMapping("users")
    public ResponseEntity<List<PublicUsers>> getUserDetails() {
        return ResponseEntity.ok(fileProcessingService.getPublicUsersList());
    }

    @GetMapping("process-users")
    public ResponseEntity<ResponseDetails> processPublicUsers() {

        Notification notification = new Notification();
        notification.setStatus(NotificationStatus.PENDING.name());
        notification = notificationService.saveNotification(notification);

        publicUserService.addUsers(notification);

        return ResponseEntity.ok(new ResponseDetails(
                "Users are being processed." +
                        "Use the following link to check the status. \n " +
                        "http://localhost:7001/data/api/v1/notification/" + notification.getId() + " "
        ));
    }

    @GetMapping("process-workbook")
    public ResponseEntity<ResponseDetails> getProcessedWorkbook(
            @RequestParam String emailAddress,
            @RequestParam String fileName,
            @RequestParam String processType
    ) {

        Notification notification = new Notification();
        notification.setStatus(NotificationStatus.PENDING.name());
        notification = notificationService.saveNotification(notification);

        excelService.createExcelFile(emailAddress, fileName, notification,processType);

        return ResponseEntity.ok(new ResponseDetails(
                "The workbook is being processed. Please wait." +
                        "Use the following link to check the status. \n " +
                        "http://localhost:7001/data/api/v1/notification/" + notification.getId() + " "
        ));
    }

    @GetMapping("notification/{notificationId}")
    public ResponseEntity<ResponseDetails> getNotificationById(@PathVariable String notificationId) {
        String notificationStr = notificationService.findById(notificationId);
        return ResponseEntity.ok(new ResponseDetails(notificationStr));
    }



}
