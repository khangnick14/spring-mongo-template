package com.example.templatesample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "category")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
    @Id
    private String categoryID;
    private String name;
    private String parent;
    private Boolean isLeaf;
    private List<Product> productList;

    public void updateCategory(Category newCategory) {
        this.categoryID = newCategory.getCategoryID();
        this.name = newCategory.getName();
        this.parent = newCategory.getParent();
        this.isLeaf = newCategory.getIsLeaf();
        this.productList = newCategory.getProductList();
    }
}
