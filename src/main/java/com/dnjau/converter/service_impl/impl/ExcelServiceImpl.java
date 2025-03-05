package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.Pojo.EmailDetails;
import com.dnjau.converter.Pojo.EnumeratedParcelUsers;
import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.helper_class.NotificationStatus;
import com.dnjau.converter.model.Notification;
import com.dnjau.converter.model.PublicUsers;
import com.dnjau.converter.repository.PublicUsersRepository;
import com.dnjau.converter.service_impl.service.EmailService;
import com.dnjau.converter.service_impl.service.ExcelService;
import com.dnjau.converter.service_impl.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


@Service
@Slf4j
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService {

    private final FileProcessingServiceImpl fileProcessingService;
    private final PublicUsersRepository publicUsersRepository;
    private final EmailService emailService;
    private final NotificationService notificationService;

    @Async
    @Override
    public void createExcelFile(String email, String fileName, Notification notification) {

        try {

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

            byte[] newWorkbookByte = saveWorkBook(workbook);
            workbook.close();

            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setRecipient(email);
            emailDetails.setSubject("Processed Excel File - "+fileName);
            emailDetails.setMsgBody("Please find the attached file.");

            emailService.sendMailWithAttachment(
                    emailDetails, newWorkbookByte, fileName, notification);

            log.warn("propertyDetailsList: {}", propertyDetailsList.size());


        }catch (Exception e) {
            notificationService.updateStatus(notification.getId(), NotificationStatus.FAILED.name());

            e.printStackTrace();
        }
    }

    private byte[] saveWorkBook(XSSFWorkbook workbook) {
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
