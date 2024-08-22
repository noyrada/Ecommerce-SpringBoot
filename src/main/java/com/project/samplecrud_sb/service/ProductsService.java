package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.exceptions.AlreadyExistException;
import com.project.samplecrud_sb.model.entity.ProductsEntity;
import com.project.samplecrud_sb.model.request.products.ProductsRequest;
import com.project.samplecrud_sb.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    //dependency injection:
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //create products:
    public ProductsEntity create(ProductsRequest productsRequest) throws Exception {
        //prepare request to entity:
        ProductsEntity data = productsRequest.toEntity();

        //save data to db:
        try {
            return this.productsRepository.save(data);

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //find all data:


}
