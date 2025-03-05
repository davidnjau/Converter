package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.model.PublicUsers;
import com.dnjau.converter.repository.PublicUsersRepository;
import com.dnjau.converter.service_impl.service.PublicUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublicUsersImpl implements PublicUserService {

    private final FileProcessingServiceImpl fileProcessingService;
    private final PublicUsersRepository publicUsersRepository;

    @Async
    @Override
    public CompletableFuture<Void> addUsers() {

        List<PublicUsers> publicUserList = fileProcessingService.getPublicUsersList();

        if (publicUserList.isEmpty()) {
            log.info("No users to process.");
            return CompletableFuture.completedFuture(null);
        }

        publicUserList.forEach(publicUsers -> {
            if (!publicUsersRepository.existsById(publicUsers.getUserId())) {
                publicUsersRepository.save(publicUsers);
            } else {
                log.info("User with ID {} already exists.", publicUsers.getUserId());
            }
         });

        log.info("Users {} have been added.", publicUserList.size());

        publicUserList.clear();

        return CompletableFuture.completedFuture(null);
    }

}
