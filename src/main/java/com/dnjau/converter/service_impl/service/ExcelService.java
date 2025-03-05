package com.dnjau.converter.service_impl.service;

import com.dnjau.converter.model.Notification;

public interface ExcelService {
    String createExcelFile(String email, String fileName, Notification notification);
}
