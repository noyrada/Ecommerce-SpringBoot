package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import com.project.samplecrud_sb.model.request.CategoryRequest;
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

    public CategoryEntity create(CategoryRequest request){
        return this.categoryRepository.save(request.toEntity());
    }
}
