package com.example.templatesample.service;

import com.example.templatesample.model.Product;
import com.example.templatesample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<String> create(Product product) {
        return new ResponseEntity<>("Successfully create product "
                        + productRepository.save(product).getProductID(), HttpStatus.OK);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public ResponseEntity<Product> updateProduct(String id, Product product) {
        Optional<Product> productData = productRepository.findById(id);
        if(productData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product _product = productData.get();
        _product.updateProduct(product);
        productRepository.save(_product);
        return new ResponseEntity<>(_product, HttpStatus.OK);    }

    @Override
    public ResponseEntity<String> deleteProduct(String id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Successfully delete a product " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot find a product",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
