package com.example.templatesample.controller;

import com.example.templatesample.model.Category;
import com.example.templatesample.model.Product;
import com.example.templatesample.service.CategoryService;
import com.example.templatesample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Create
    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    //Get all
    @GetMapping("/all-categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //Get by ID
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable String id) {
        return categoryService.getCategoryById(id);
    }

    //Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable String id) {
        return categoryService.deleteCategory(id);
    }

    //Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable String id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }
}
