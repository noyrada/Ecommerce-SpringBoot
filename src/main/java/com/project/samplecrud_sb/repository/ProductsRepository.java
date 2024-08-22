package com.project.samplecrud_sb.repository;

import com.project.samplecrud_sb.model.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity,Long> {
    //JPQL = Java persistence Queries Language
    boolean existsByName(String name);
}
