package com.geekbrains.project.service;

import com.geekbrains.project.entity.Cart;
import com.geekbrains.project.entity.Person;
import com.geekbrains.project.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }

    public Cart getCart(Person person){
        return cartRepository.findCartByPerson(person);
    }
}
