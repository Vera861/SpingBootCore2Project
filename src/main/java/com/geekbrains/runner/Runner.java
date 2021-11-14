package com.geekbrains.runner;

import com.geekbrains.entity.Person;
import com.geekbrains.entity.Product;
import com.geekbrains.repository.CartRepository;
import com.geekbrains.repository.ProductRepository;
import com.geekbrains.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

        if (personRepository.count() == 0) {
                Person person = new Person();
                person.setFirstName("User");
                person.setLastName("Cool");
                person.setRole("ADMIN");
                person.setPhone("999-99-99");
                personRepository.save(person);
            for (int i = 0; i < 3; i++) {
                person = new Person();
                person.setFirstName("Name-" + i);
                person.setLastName("LastName-" + i);
                person.setRole("CUSTOMER");
                person.setPhone(i+"00-00-00");
                personRepository.save(person);
            }
        }

        if (productRepository.count()==0){
            Person person = personRepository.findPersonByFirstName("Admin");
            if(person !=null){
                Product product = new Product();
                product.setName("Яблоки");
                product.setPrice(BigDecimal.valueOf(105.60));
                product.setVendorCode("Сады и огороды -1");
                product.setUser(person);
                productRepository.save(product);

                product = new Product();
                product.setName("Карандаши");
                product.setPrice(BigDecimal.valueOf(55.0));
                product.setVendorCode("Сибирские лесозаготовки -1");
                product.setUser(person);
                productRepository.save(product);
            }

        }

    }
}
