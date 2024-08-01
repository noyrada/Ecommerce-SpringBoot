package com.project.samplecrud_sb.model.request;


import com.project.samplecrud_sb.model.entity.CategoryEntity;
import com.project.samplecrud_sb.model.response.category.CategoryResponse;

import java.io.Serializable;

public class CategoryRequest implements Serializable {

    private String name;
    private String description;

    public CategoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryEntity toEntity(){
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setName(this.name);
        categoryEntity.setDescription(this.description);
        return categoryEntity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
