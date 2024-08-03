package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.exceptions.AlreadyExistException;
import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.CategoryEntity;
import com.project.samplecrud_sb.model.request.category.CategoryRequest;
import com.project.samplecrud_sb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Save Method:
    public CategoryEntity create(CategoryRequest request) throws Exception {

        //prepare request to entity
        CategoryEntity data = request.toEntity();

        //check name from request in database
        if (this.categoryRepository.existsByName(data.getName()))
            throw new AlreadyExistException("Category name already exists!");

        try {
            //save entity
            return this.categoryRepository.save(data);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //Update Method:
    public CategoryEntity update(Long id, CategoryRequest request) throws Exception {

        //check field in database and if isn't exist than throw error
        CategoryEntity foundData = this.categoryRepository.findById(id).orElseThrow(()
            -> new NotFoundException("Category not found!"));

        //Add request data into exist database:

        //#1. need give all field's value to update
       foundData.setName(request.getName());
       foundData.setDescription(request.getDescription());

        //#2. update only filed that specify:
        //foundData.setName(request.getName() == null ? foundData.getName() : request.getName());
        //foundData.setDescription(request.getDescription() == null ? foundData.getDescription() : request.getDescription());

        //update entity:
        try {
            //save entity
            return this.categoryRepository.save(foundData);
        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

}
