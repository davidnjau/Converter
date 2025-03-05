package com.dnjau.converter.service_impl.impl;

import com.dnjau.converter.model.PublicUsers;
import com.dnjau.converter.repository.PublicUsersRepository;
import com.dnjau.converter.service_impl.service.PublicUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublicUsersImpl implements PublicUserService {

    private final FileProcessingServiceImpl fileProcessingService;
    private final PublicUsersRepository publicUsersRepository;

    @Override
    public void addUsers() {

        List<PublicUsers> publicUserList = fileProcessingService.getPublicUsersList();
        publicUsersRepository.saveAll(publicUserList);
        publicUserList.clear();

    }

}
