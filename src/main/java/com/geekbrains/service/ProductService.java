package com.geekbrains.service;

import com.geekbrains.aspect.Profiler;
import com.geekbrains.entity.Product;
import com.geekbrains.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Profiler
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
