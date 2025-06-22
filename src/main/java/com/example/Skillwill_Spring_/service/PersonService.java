package com.example.Skillwill_Spring_.service;

import com.example.Skillwill_Spring_.model.Person;
import com.example.Skillwill_Spring_.repository.PersonRepository;
import com.example.Skillwill_Spring_.repository.PersonRepository.PersonView;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    // Add test data on startup
    @PostConstruct
    public void addTestData() {
        personRepository.save(new Person(null, "John", "Doe"));
        personRepository.save(new Person(null, "Jane", "Smith"));
        personRepository.save(new Person(null, "Alice", "Johnson"));

        System.out.println("All persons:");
        Page<Person> page = personRepository.findAll(PageRequest.of(0, 10));
        for (Person p : page.getContent()) {
            System.out.println(p.getId() + ": " + p.getName() + " " + p.getLastname());
        }

        System.out.println("\nPerson with id 1:");
        Person p1 = personRepository.findById(1).orElse(null);
        if (p1 != null) {
            System.out.println(p1.getId() + ": " + p1.getName() + " " + p1.getLastname());
        } else {
            System.out.println("Not found");
        }

        if (p1 != null) {
            p1.setName("UpdatedName");
            p1.setLastname("UpdatedLastname");
            personRepository.save(p1);
            System.out.println("\nUpdated person with id 1:");
            Person updated = personRepository.findById(1).orElse(null);
            if (updated != null) {
                System.out.println(updated.getId() + ": " + updated.getName() + " " + updated.getLastname());
            }
        }

        personRepository.deleteById(2);
        System.out.println("\nAfter deleting person with id 2:");
        Page<Person> page2 = personRepository.findAll(PageRequest.of(0, 10));
        for (Person p : page2.getContent()) {
            System.out.println(p.getId() + ": " + p.getName() + " " + p.getLastname());
        }
    }

    // Create
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // Read all with projection and pagination
    public Page<PersonView> getAllPersons(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return personRepository.findAllProjectedBy(pageable);
    }

    // Read one with projection
    public PersonView getPerson(Integer id) {
        return personRepository.findProjectedById(id);
    }

    // Update
    public Person updatePerson(Integer id, Person updated) {
        return personRepository.findById(id).map(person -> {
            person.setName(updated.getName());
            person.setLastname(updated.getLastname());
            return personRepository.save(person);
        }).orElse(null);
    }

    // Delete
    public boolean deletePerson(Integer id) {
        if (!personRepository.existsById(id)) return false;
        personRepository.deleteById(id);
        return true;
    }
}
