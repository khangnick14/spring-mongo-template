package com.example.templatesample.service;

import com.example.templatesample.model.Category;
import com.example.templatesample.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    ResponseEntity<String> createCategory(Category category);
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(String id);
    ResponseEntity<Category> updateCategory(String id, Category category);
    ResponseEntity<String> deleteCategory(String id);
}
