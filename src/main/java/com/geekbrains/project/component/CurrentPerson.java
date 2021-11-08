package com.geekbrains.project.component;

import com.geekbrains.project.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentPerson {
    private Person person;

    public Person getUser() {
        return person;
    }

    public void setUser(Person person) {
        this.person = person;
    }
}
