package com.project.samplecrud_sb.model.response.products;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import com.project.samplecrud_sb.model.entity.ProductsEntity;
import com.project.samplecrud_sb.model.response.category.CategoryResponse;

import java.io.Serializable;

public class ProductsResponse implements Serializable {

   private Long id;
   private String name;
   private String description;
   private Double price;

    public ProductsResponse(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static ProductsResponse fromEntity(ProductsEntity entity){
        return new ProductsResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
