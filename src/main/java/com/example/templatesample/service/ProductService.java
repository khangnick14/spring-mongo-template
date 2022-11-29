package com.example.templatesample.service;


import com.example.templatesample.model.Category;
import com.example.templatesample.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ResponseEntity<String> create(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductById(String id);
    ResponseEntity<Product> updateProduct(String id, Product product);
    ResponseEntity<String> deleteProduct(String id);
}
