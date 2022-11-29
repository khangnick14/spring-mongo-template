package com.example.templatesample.controller;

import com.example.templatesample.model.Category;
import com.example.templatesample.model.Product;
import com.example.templatesample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    //Create
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    //Get All
    @GetMapping("/all-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //Get by ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    //Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

    //Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
