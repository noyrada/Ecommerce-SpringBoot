package com.project.samplecrud_sb.controller.backend;

import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.CategoryEntity;
import com.project.samplecrud_sb.model.request.category.CategoryRequest;
import com.project.samplecrud_sb.model.response.category.CategoryResponse;
import com.project.samplecrud_sb.model.response.errors.ErrorResponse;
import com.project.samplecrud_sb.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Backend Category Controller",description = "Controller for admin manage category.")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest request) throws Exception{
        CategoryEntity category = this.categoryService.create(request);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody CategoryRequest request) throws Exception{
        CategoryEntity category = this.categoryService.update(id,request);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){

        List<CategoryResponse> category = this.categoryService.findAll().stream().map
                (CategoryResponse::fromEntity).toList();
        return ResponseEntity.ok(category);
    }

    @Operation(summary = "Endpoint for admin finding a category",description = "Admin can find a category by id",
    responses = {
            @ApiResponse(description = "Success",responseCode = "200", content = @Content(schema = @Schema(implementation = CategoryResponse.class),mediaType = "application/json")),
            @ApiResponse(description = "Error",responseCode = "400-500", content = @Content(schema = @Schema(implementation = ErrorResponse.class),mediaType = "application/json"))
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findOne(@PathVariable Long id) throws NotFoundException {
        CategoryEntity category = this.categoryService.findOne(id);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable Long id) throws Exception{
        CategoryEntity category = this.categoryService.delete(id);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }
}
