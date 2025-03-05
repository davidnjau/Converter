package com.dnjau.converter.service_impl.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelService {
    String createExcelFile(String email, String fileName);
}
