package com.example.templatesample.service;

import com.example.templatesample.model.Category;
import com.example.templatesample.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<String> createCategory(Category category) {
        return new ResponseEntity<>("Successfully create category " + categoryRepository.save(category).getCategoryID(), HttpStatus.OK);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public ResponseEntity<Category> updateCategory(String id, Category category) {
        Optional<Category> categoryData = categoryRepository.findById(id);
        if(categoryData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Category _category = categoryData.get();
        _category.updateCategory(category);
        categoryRepository.save(_category);
        return new ResponseEntity<>(_category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCategory(String id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>("Successfully delete a category " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot find a category",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
