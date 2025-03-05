package com.dnjau.converter.repository;

import com.dnjau.converter.model.PublicUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicUsersRepository extends JpaRepository<PublicUsers, String> {
    //Get the user details by id
    PublicUsers findByUserId(String userId);
}