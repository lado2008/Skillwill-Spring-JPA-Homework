package com.example.Skillwill_Spring_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Skillwill_Spring_.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    
}
