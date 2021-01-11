package com.learning.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.restapi.model.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
    public user findByUsername(String username); 
}
