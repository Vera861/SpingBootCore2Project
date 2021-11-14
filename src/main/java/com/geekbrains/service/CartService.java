package com.geekbrains.service;

import com.geekbrains.aspect.Profiler;
import com.geekbrains.entity.Cart;
import com.geekbrains.entity.Person;
import com.geekbrains.repository.CartRepository;
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

    @Profiler
    public Cart getCart(Person person){
        return cartRepository.findCartByUser(person);
    }
}
