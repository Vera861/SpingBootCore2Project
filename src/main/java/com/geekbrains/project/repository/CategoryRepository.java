package com.geekbrains.project.repository;
import com.geekbrains.project.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
