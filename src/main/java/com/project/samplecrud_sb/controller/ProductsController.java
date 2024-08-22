package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.model.entity.ProductsEntity;
import com.project.samplecrud_sb.model.request.products.ProductsRequest;
import com.project.samplecrud_sb.model.response.products.ProductsResponse;
import com.project.samplecrud_sb.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController{

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping
    public ResponseEntity<ProductsResponse> create(@RequestBody ProductsRequest productsRequest)throws Exception{
        ProductsEntity productsEntity = this.productsService.create(productsRequest);
        return ResponseEntity.ok(ProductsResponse.fromEntity(productsEntity));
    }
}
