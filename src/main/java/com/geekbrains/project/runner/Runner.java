package com.geekbrains.project.runner;

import com.geekbrains.project.entity.Cart;
import com.geekbrains.project.entity.Person;
import com.geekbrains.project.entity.Product;
import com.geekbrains.project.repository.CartRepository;
import com.geekbrains.project.repository.PersonRepository;
import com.geekbrains.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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
      Person person = new Person();
        person.setPhone("123");
        person.setLastName("Eremin");
        person.setPassword("123");

        person = personRepository.save(person);

        Cart cart = new Cart();
        cart.setPerson(person);

        Cart.InnerProduct product = new Cart.InnerProduct();
        product.setCount(1);
        product.setName("Арбуз");
        product.setPrice(BigDecimal.TEN);

        cart.setProducts(List.of(product));

        cart = cartRepository.save(cart);

        System.out.println(cart.getProducts());

//        Product product = new Product();
//
//        var person = personRepository.findById(UUID.fromString("c6b7202d-f7bf-40f8-a2ec-9703be4e1adf")).get();
//        product.setCreatedBy(person);
//        product.setCount(1);
//        product.setPrice(BigDecimal.TEN);
//        product.setVendorCode("123");
//        product.setName("Арбуз");

        productRepository.save(product);

    }

//    id
//    card_type = CREDIT_CARD, DEBET_CARD;
//    card_into = CreditCard, DebetCard
}
