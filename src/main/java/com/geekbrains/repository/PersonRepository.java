package com.geekbrains.repository;

import com.geekbrains.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {
    Person findPersonByFirstName(String name);
    Person findPersonByLogin(String name);
}

