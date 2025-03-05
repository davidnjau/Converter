package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.Pojo.UserDetails;
import com.dnjau.converter.service_impl.service.FileProcessingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;


@Slf4j
@Service
public class FileProcessingServiceImpl implements FileProcessingService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Getter
    private final List<PropertyDetails> propertyDetailsList = new ArrayList<>();
    @Getter
    private final List<UserDetails> userDetailsList = new ArrayList<>();

    @Override
    public void processFile(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            // Read the JSON file as a list of JSON objects
            List<JsonNode> jsonNodes = objectMapper.readValue(inputStream, new TypeReference<>() {});

            for (JsonNode node : jsonNodes) {
                processJsonObject(node);
            }

            log.info("Finished processing file. Total Properties: {}, Total Users: {}",
                    propertyDetailsList.size(), userDetailsList.size());

        } catch (IOException e) {
            log.error("Error processing file", e);
        }
    }

    private void processJsonObject(JsonNode node) {
        if (node.has("holding_type") && node.has("property_number")) {
            PropertyDetails property = objectMapper.convertValue(node, PropertyDetails.class);
            propertyDetailsList.add(property);
        } else if (node.has("Full Name") && node.has("Phone Num")) {
            UserDetails user = objectMapper.convertValue(node, UserDetails.class);
            userDetailsList.add(user);
        } else {
            log.warn("Unknown JSON structure: {}", node);
        }
    }

}