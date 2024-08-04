package com.project.samplecrud_sb.repository;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    //JPQL = Java persistence Queries Language
    boolean existsByName(String name);

}
