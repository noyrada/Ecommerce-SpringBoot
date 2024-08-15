package com.project.samplecrud_sb.repository;

import com.project.samplecrud_sb.model.entity.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<TagsEntity,Long> {

}
