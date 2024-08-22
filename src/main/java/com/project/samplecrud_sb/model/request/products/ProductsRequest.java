package com.project.samplecrud_sb.model.request.products;

import com.project.samplecrud_sb.model.entity.ProductsEntity;

import java.io.Serializable;

public class ProductsRequest implements Serializable {

    private String name;
    private String description;
    private Double price;

    public ProductsRequest(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductsEntity toEntity(){
        ProductsEntity products = new ProductsEntity();
        products.setName(this.getName());
        products.setName(this.getDescription());
        products.setPrice(this.getPrice());
        return products;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
