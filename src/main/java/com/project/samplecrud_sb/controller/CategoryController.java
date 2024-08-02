package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import com.project.samplecrud_sb.model.request.CategoryRequest;
import com.project.samplecrud_sb.model.response.category.CategoryResponse;
import com.project.samplecrud_sb.repository.CategoryRepository;
import com.project.samplecrud_sb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request){

        CategoryEntity category = this.categoryService.create(request);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

}
