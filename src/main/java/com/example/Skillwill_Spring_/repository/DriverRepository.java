package com.example.Skillwill_Spring_.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Skillwill_Spring_.model.Driver;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findByAgeGreaterThan(int age);

    List<Driver> findByNationality(String nationality);

    List<Driver> findByTeamContainingIgnoreCase(String team);
    
}
