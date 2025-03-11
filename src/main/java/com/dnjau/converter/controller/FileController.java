package com.dnjau.converter.controller;

import com.dnjau.converter.helper_class.NotificationStatus;
import com.dnjau.converter.model.Notification;
import com.dnjau.converter.model.ResponseDetails;
import com.dnjau.converter.service_impl.service.FileProcessingService;
import com.dnjau.converter.service_impl.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(
        origins =
                {
                        "http://localhost:5173",
                        "http://localhost:3000",
                        "http://localhost:80",

                        "http://192.168.214.175:3000",
                        "http://192.168.214.175:80",

                        "http://converter_frontend:3000",
                        "http://converter_frontend:80"
                }
)
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
                "http://localhost:7001/data/api/v1/notification/" + notification.getId() + " " ));
    }


}
