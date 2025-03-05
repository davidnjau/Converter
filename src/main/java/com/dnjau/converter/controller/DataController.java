package com.dnjau.converter.controller;

import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.Pojo.UserDetails;
import com.dnjau.converter.model.PublicUsers;
import com.dnjau.converter.service_impl.impl.FileProcessingServiceImpl;
import com.dnjau.converter.service_impl.service.ExcelService;
import com.dnjau.converter.service_impl.service.PublicUserService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/data/")
@RequiredArgsConstructor
public class DataController {

    private final FileProcessingServiceImpl fileProcessingService;
    private final PublicUserService publicUserService;
    private final ExcelService excelService;

    @GetMapping("properties")
    public ResponseEntity<List<PropertyDetails>> getPropertyDetails() {
        return ResponseEntity.ok(fileProcessingService.getPropertyDetailsList());
    }

    @GetMapping("users")
    public ResponseEntity<List<PublicUsers>> getUserDetails() {
        return ResponseEntity.ok(fileProcessingService.getPublicUsersList());
    }

    @GetMapping("process-users")
    public ResponseEntity<String> processPublicUsers() {
        publicUserService.addUsers();
        return ResponseEntity.ok("Users are being processed.");
    }

    @GetMapping("process-workbook")
    public ResponseEntity<byte[]> getProcessedWorkbook() {


        try {
            XSSFWorkbook workbook = excelService.createExcelFile();

            byte[] newWorkbookByte = saveWorkBook(workbook);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentDispositionFormData("attachment", "processed.xlsx");

            workbook.close();

            return new ResponseEntity<>(newWorkbookByte, httpHeaders, HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    private byte[] saveWorkBook(XSSFWorkbook workbook) {
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
