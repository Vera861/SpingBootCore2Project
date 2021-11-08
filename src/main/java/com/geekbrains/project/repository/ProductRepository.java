package com.geekbrains.project.repository;

import com.geekbrains.project.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
    List<Product> findAll();
}
