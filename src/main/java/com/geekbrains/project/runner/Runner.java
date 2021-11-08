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
public class Runner<person, cart> implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if (personRepository.count() == 0) {
            Person person = new Person();
            person.setFirstName("Admin");
            person.setLastName("Cool");
            person.setRole("ADMIN");
            person.setPhone("257-63-55");
            personRepository.save(person);
            for (int i = 0; i < 3; i++) {
                person = new Person();
                person.setFirstName("Name-" + i);
                person.setLastName("LastName-" + i);
                person.setRole("CUSTOMER");
                person.setPhone(i + "00-00-00");
                personRepository.save(person);
            }
        }

        if (productRepository.count() == 0) {
            Person person = personRepository.findPersonByFirstName("Admin");
            if (person != null) {
                Product product = new Product();
                product.setName("Арбуз");
                product.setPrice(BigDecimal.valueOf(15));
                product.setVendorCode("Кубанская ярмарка -1");
                product.setPerson(person);
                productRepository.save(product);

                product = new Product();
                product.setName("Помидор");
                product.setPrice(BigDecimal.valueOf(15));
                product.setVendorCode("Агроресурс -1");
                product.setPerson(person);
                productRepository.save(product);
            }

        }
    }
}
