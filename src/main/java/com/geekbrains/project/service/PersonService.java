package com.geekbrains.project.service;

import com.geekbrains.project.entity.Person;
import com.geekbrains.project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findUserByName(String name){
       return personRepository.findPersonByFirstName(name);
    }
}
