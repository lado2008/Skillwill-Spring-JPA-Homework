package com.example.Skillwill_Spring_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Skillwill_Spring_.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
