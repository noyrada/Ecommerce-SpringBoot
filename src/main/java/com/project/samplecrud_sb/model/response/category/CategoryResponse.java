package com.project.samplecrud_sb.model.response.category;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class CategoryResponse implements Serializable {

    @Schema(example = "168")
    private Long id;

    @Schema(example = "Best Category")
    private String name;

    @Schema(example = "Best Category ever.")
    private String description;

    public CategoryResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static CategoryResponse fromEntity(CategoryEntity entity){
        return new CategoryResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
