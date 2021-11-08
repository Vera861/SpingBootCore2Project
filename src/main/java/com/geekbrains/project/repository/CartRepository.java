package com.geekbrains.project.repository;

import com.geekbrains.project.entity.Cart;
import com.geekbrains.project.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CartRepository extends CrudRepository<Cart, UUID> {
    Cart findCartByPerson(Person person);
}
