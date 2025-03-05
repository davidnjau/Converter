package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.Pojo.CompanyDetails;
import com.dnjau.converter.Pojo.PropertyDetails;
import com.dnjau.converter.Pojo.UserDetails;
import com.dnjau.converter.model.PublicUsers;
import com.dnjau.converter.repository.PublicUsersRepository;
import com.dnjau.converter.service_impl.service.FileProcessingService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import com.fasterxml.jackson.core.type.TypeReference;


@Slf4j
@Service
public class FileProcessingServiceImpl implements FileProcessingService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PublicUsersRepository publicUsersRepository;

    @Getter
    private final List<PropertyDetails> propertyDetailsList = new CopyOnWriteArrayList<>();
    @Getter
    private final List<PublicUsers> publicUsersList = new CopyOnWriteArrayList<>();

    public FileProcessingServiceImpl(PublicUsersRepository publicUsersRepository) {
        this.publicUsersRepository = publicUsersRepository;
    }

    @Async
    @Override
    public CompletableFuture<Void> processFile(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            // Read the JSON file as a list of JSON objects
            List<JsonNode> jsonNodes = objectMapper.readValue(inputStream, new TypeReference<>() {});

            for (JsonNode node : jsonNodes) {
                processJsonObject(node);
            }

            log.info("Finished processing file. Total Properties: {}, Total Users: {}",
                    propertyDetailsList.size(), publicUsersList.size());

            return CompletableFuture.completedFuture(null);

        } catch (IOException e) {
            log.error("Error processing file", e);
        }
        return CompletableFuture.completedFuture(null);

    }

    private void processJsonObject(JsonNode node) {
        if (node.has("holding_type") && node.has("property_number")) {
            PropertyDetails property = objectMapper.convertValue(node, PropertyDetails.class);
            synchronized (propertyDetailsList){
                propertyDetailsList.add(property);
            }

        } else if (node.has("Full Name") && node.has("Phone Num")) {

            UserDetails user = objectMapper.convertValue(node, UserDetails.class);
            boolean isUserExist = publicUsersRepository.existsById(user.getUserId());
            if (!isUserExist) {
                // Create a new PublicUsers object and save it to the database
                PublicUsers publicUsers = new PublicUsers();
                publicUsers.setUserId(user.getUserId());
                publicUsers.setPhoneNumber(user.getPhoneNum());
                publicUsers.setEmailAddress(user.getEmail());
                publicUsers.setFullName(user.getFullName());
                publicUsers.setKraPin(user.getKrApIn());
                publicUsers.setUserType("USER");
                synchronized (publicUsersList){
                    publicUsersList.add(publicUsers);
                }
            }

        }else if(node.has("Kra Pin") && node.has("Registration Number")) {

            CompanyDetails companyDetails = objectMapper.convertValue(node, CompanyDetails.class);
            boolean isUserExist = publicUsersRepository.existsById(companyDetails.getUserId());
            if (!isUserExist) {
                // Create a new CompanyDetails object and save it to the database
                PublicUsers publicUsers = getPublicUsers(companyDetails);
                synchronized (publicUsersList){
                    publicUsersList.add(publicUsers);
                }
            }

        } else {
            log.warn("Unknown JSON structure: {}", node);
        }
    }

    private static PublicUsers getPublicUsers(CompanyDetails companyDetails) {
        PublicUsers publicUsers = new PublicUsers();
        publicUsers.setUserId(companyDetails.getUserId());
        publicUsers.setPhoneNumber(companyDetails.getPhoneNumber());
        publicUsers.setEmailAddress(companyDetails.getEmail());
        publicUsers.setFullName(companyDetails.getFullName());
        publicUsers.setKraPin(companyDetails.getKraPin());
        publicUsers.setUserType("COMPANY");
        return publicUsers;
    }

}