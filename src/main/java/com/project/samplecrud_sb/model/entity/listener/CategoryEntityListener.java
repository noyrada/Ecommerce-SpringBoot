package com.project.samplecrud_sb.model.entity.listener;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import jakarta.persistence.*;

import java.util.logging.Logger;

public class CategoryEntityListener {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    //jpa entities lifecycle events:
    @PrePersist
    public void beforeSave(CategoryEntity category){
        log.info("Before Category persisted Id:"+category.getId()+
                      "  Name:"+category.getName()+
                      " and Description:"+ category.getDescription());
    }

    @PostPersist
    public void afterSave(CategoryEntity category){
        log.info("After Category persisted Id:"+category.getId()+
                      " Name:"+category.getName()+
                      " and Description:"+ category.getDescription());
    }

    @PreUpdate
    public void beforeUpdate(CategoryEntity category){
        log.info("Before Category Merged Id:"+category.getId()+
                      " Name:"+category.getName()+
                      " and Description:"+ category.getDescription());
    }

    @PostUpdate
    public void afterUpdate(CategoryEntity category){
        log.info("After Category Merged Id:"+category.getId()+
                      "  Name:"+category.getName()+
                      " and Description:"+ category.getDescription());
    }

    @PreRemove
    public void beforeRemove(CategoryEntity category){
        log.info("Before Category Removed Id:"+category.getId()+
                      " Name:"+category.getName()+
                      " and Description:"+ category.getDescription());
    }

    @PostRemove
    public void afterRemove(CategoryEntity category){
        log.info("After Category Removed Id:"+category.getId()+
                      " Name:"+category.getName()+
                      " and Description:"+ category.getDescription());
    }

    @PostLoad
    public void load(CategoryEntity category){
        Logger log = Logger.getLogger(this.getClass().getName());
        log.info("After Category Loaded Id:"+category.getId()+
                      " Name:"+category.getName()+
                      " and Description:"+ category.getDescription());
    }
}
