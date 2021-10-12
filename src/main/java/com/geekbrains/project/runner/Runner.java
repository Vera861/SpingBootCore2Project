package com.geekbrains.project.runner;

import com.geekbrains.project.repository.CartRepository;
import com.geekbrains.project.repository.PersonRepository;
import com.geekbrains.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}
