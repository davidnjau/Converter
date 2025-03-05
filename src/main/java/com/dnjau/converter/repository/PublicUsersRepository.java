package com.dnjau.converter.repository;

import com.dnjau.converter.model.PublicUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublicUsersRepository extends JpaRepository<PublicUsers, String> {
    //Get the user details by id
    Optional<PublicUsers> findByUserId(String userId);
    boolean existsById(String userId);

}