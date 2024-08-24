package com.project.samplecrud_sb.repository;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    //JPQL = Java persistence Queries Language
    @Query("select (count(c) > 0) from Category c where c.name = ?1")
    boolean existsByName(String name);


    @Query("select c from Category c where upper(c.name) like upper(concat('%', :name, '%'))")
    List<CategoryEntity> findAllByNameContainingIgnoreCase(@Param("name") String name);


    //Native Query: <find All>
    @Query(value = "SELECT * FROM categories",nativeQuery = true)
    List<CategoryEntity> findAllByUsingNativeQuery();


    //Sorting by ID: ASC
    @Query(value = "select c from Category c order by c.id asc ")
    List<CategoryEntity> findAllByOrderByIdAsc();

    //Sorting by ID: DESC
    @Query(value = "select c from Category c order by c.id desc ")
    List<CategoryEntity> findAllByOrderByIdDesc();

    //Sorting by Name: ASC
    @Query(value = "select c from Category c order by c.name asc ")
    List<CategoryEntity> findAllByOrderByNameAsc();

    //Sorting by Name: DESC
    @Query(value = "select c from Category c order by c.name desc ")
    List<CategoryEntity> findAllByOrderByNameDesc();


//    //Pagination:

}
