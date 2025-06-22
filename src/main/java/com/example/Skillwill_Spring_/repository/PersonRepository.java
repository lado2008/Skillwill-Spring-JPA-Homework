package com.example.Skillwill_Spring_.repository;

import com.example.Skillwill_Spring_.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Projection for custom response
    interface PersonView {
        Integer getId();
        String getName();
        String getLastname();
    }

    // Find all with projection and pagination
    @Query("SELECT p.id AS id, p.name AS name, p.lastname AS lastname FROM Person p")
    Page<PersonView> findAllProjectedBy(Pageable pageable);

    // Find by id with projection
    @Query("SELECT p.id AS id, p.name AS name, p.lastname AS lastname FROM Person p WHERE p.id = :id")
    PersonView findProjectedById(@Param("id") Integer id);
}
