package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.Pojo.EnumeratedParcelUsers;
import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.model.PublicUsers;
import com.dnjau.converter.repository.PublicUsersRepository;
import com.dnjau.converter.service_impl.service.ExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


@Service
@Slf4j
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService {

    private final FileProcessingServiceImpl fileProcessingService;
    private final PublicUsersRepository publicUsersRepository;

    @Override
    public XSSFWorkbook createExcelFile() {

        Queue<EnumeratedParcelUsers> propertyDetailsList = new ConcurrentLinkedQueue<>();
        XSSFWorkbook workbook = new XSSFWorkbook();

        List<PropertyDetails> propertyList = fileProcessingService.getPropertyDetailsList();
        propertyList.forEach(property -> {

            String propertyNumber = property.getPropertyNumber();
            String holdingType = property.getHoldingType();
            String approximateArea = property.getApproximateArea();
            String areaUnits = property.getAreaUnits();
            String natureOfTitle = property.getNatureOfTitle();
            String userId = property.getUserId();

            Optional<PublicUsers> publicUsers = publicUsersRepository.findByUserId(userId);
            if (publicUsers.isPresent()) {
                String phoneNumber = publicUsers.get().getPhoneNumber();
                String emailAddress = publicUsers.get().getEmailAddress();
                String fullName = publicUsers.get().getFullName();
                String kraPin = publicUsers.get().getKraPin();

                EnumeratedParcelUsers enumeratedParcelUsers = new EnumeratedParcelUsers(
                        propertyNumber,
                        holdingType,
                        approximateArea,
                        areaUnits,
                        natureOfTitle,
                        fullName, phoneNumber, emailAddress, kraPin);
                propertyDetailsList.add(enumeratedParcelUsers);
            }else {
                log.warn("No userId: {}", userId);
                log.warn("For propertyNumber: {}", propertyNumber);
            }

        });

        addNewSheetValues(workbook, propertyDetailsList);

        log.warn("propertyDetailsList: {}", propertyDetailsList.size());

        return workbook;
    }

    private void addNewSheetValues(XSSFWorkbook workbook, Queue<EnumeratedParcelUsers> propertyDetailsList) {

        // Create a new sheet
        Sheet enumeratedParcelsSheet = workbook.createSheet("Sheet 1");

        // Define the header row values
        String[] headerList = {
                "propertyNumber", "holdingType", "approximateArea", "areaUnits",
                "natureOfTitle", "phoneNumber", "emailAddress", "fullName", "kraPin"
        };

        // Create the header row
        Row headerRow = enumeratedParcelsSheet.createRow(0);
        for (int i = 0; i < headerList.length; i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(headerList[i]);
        }

        // Fill the sheet with data from the propertyDetailsList (Queue)
        int rowNum = 1; // Start from the second row (after the header)
        for (EnumeratedParcelUsers user : propertyDetailsList) {
            Row dataRow = enumeratedParcelsSheet.createRow(rowNum++);
            dataRow.createCell(0).setCellValue(user.getPropertyNumber());
            dataRow.createCell(1).setCellValue(user.getHoldingType());
            dataRow.createCell(2).setCellValue(user.getApproximateArea());
            dataRow.createCell(3).setCellValue(user.getAreaUnits());
            dataRow.createCell(4).setCellValue(user.getNatureOfTitle());
            dataRow.createCell(5).setCellValue(user.getPhoneNumber());
            dataRow.createCell(6).setCellValue(user.getEmailAddress());
            dataRow.createCell(7).setCellValue(user.getFullName());
            dataRow.createCell(8).setCellValue(user.getKraPin());
        }

//        return workbook; // Return the filled workbook
    }


}
