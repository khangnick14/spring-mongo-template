package com.example.templatesample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    private String productID;
    private String name;
    private String brandName;
    private String longDescription;
    private Double price;
    private Category category;

    public void updateProduct(Product newProduct) {
        this.productID = newProduct.getProductID();
        this.name = newProduct.getName();
        this.brandName = newProduct.getBrandName();
        this.longDescription = newProduct.getLongDescription();
        this.price = newProduct.getPrice();
        this.category = newProduct.getCategory();
    }
}
