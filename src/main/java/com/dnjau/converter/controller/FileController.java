package com.dnjau.converter.controller;

import com.dnjau.converter.service_impl.service.FileProcessingService;
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

    @RequestMapping(value = "import", method = RequestMethod.POST)
    public ResponseEntity<String> processJson(@RequestParam("file") MultipartFile file) throws IOException {

        fileProcessingService.processFile(file);

        return ResponseEntity.ok("File processing started in the background. You will be notified when it's done.");
    }


}
