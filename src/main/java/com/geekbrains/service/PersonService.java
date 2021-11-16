package com.geekbrains.service;

import com.geekbrains.aspect.Profiler;
import com.geekbrains.entity.Person;
import com.geekbrains.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Profiler
    public Person findPersonByName(String name) {
        return personRepository.findPersonByFirstName(name);
    }

    @Profiler
    public Person findPersonByLogin(String name) {
        return personRepository.findPersonByLogin(name);
    }

    @Profiler
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
