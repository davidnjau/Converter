package com.dnjau.converter.controller;

import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.Pojo.UserDetails;
import com.dnjau.converter.service_impl.impl.FileProcessingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data/")
@RequiredArgsConstructor
public class DataController {

    private final FileProcessingServiceImpl fileProcessingService;

    @GetMapping("properties")
    public ResponseEntity<List<PropertyDetails>> getPropertyDetails() {
        return ResponseEntity.ok(fileProcessingService.getPropertyDetailsList());
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDetails>> getUserDetails() {
        return ResponseEntity.ok(fileProcessingService.getUserDetailsList());
    }
}
