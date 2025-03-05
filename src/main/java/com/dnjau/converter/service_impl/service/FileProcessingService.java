package com.dnjau.converter.service_impl.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

public interface FileProcessingService {
    CompletableFuture<Void> processFile(MultipartFile file);
}
