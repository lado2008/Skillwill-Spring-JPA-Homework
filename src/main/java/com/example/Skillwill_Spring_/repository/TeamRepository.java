package com.example.Skillwill_Spring_.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Skillwill_Spring_.model.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByTitlesGreaterThanEqual(int titles);

    List<Team> findByCountry(String country);

    List<Team> findByEngine(String engine);
}
