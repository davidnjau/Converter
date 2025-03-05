package com.dnjau.converter.service_impl.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileProcessingService {
    void processFile(MultipartFile file);
}
