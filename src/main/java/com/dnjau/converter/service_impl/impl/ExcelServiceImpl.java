package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.service_impl.service.ExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService {

    private final FileProcessingServiceImpl fileProcessingService;

    @Override
    public void createExcelFile(String fileName) {

        List<PropertyDetails> propertyList = fileProcessingService.getPropertyDetailsList();



    }
}
