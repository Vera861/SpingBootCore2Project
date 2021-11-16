package com.geekbrains.repository;

import com.geekbrains.entity.Cart;
import com.geekbrains.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CartRepository extends CrudRepository<Cart, UUID> {
    Cart findCartByUser(Person person);
}
