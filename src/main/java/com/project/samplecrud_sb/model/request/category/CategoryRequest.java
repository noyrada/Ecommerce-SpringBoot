package com.project.samplecrud_sb.model.request.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.samplecrud_sb.model.entity.CategoryEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class CategoryRequest implements Serializable {

    //@Schema(name = "nm")  //change name to nm
    //@JsonProperty("nm")   //change with database

    //make require for noted:
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED,example = "Computer",maxLength = 30)
    @NotNull(message = "Name is required!")
    @NotEmpty(message = "Name cannot be empty!")
    @Size(max = 30,message = "Name cannot be bigger than 30 characters!")
    private String name;

    @Schema(example = "Computer Category!",maxLength = 100,nullable = true)
    @Size(max = 100,message = "Description cannot be bigger than 100 characters!")
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
