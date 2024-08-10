package com.project.samplecrud_sb.repository;

import com.project.samplecrud_sb.model.entity.PostCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostCommentEntity,Long> {

    List<PostCommentEntity> findAllByPostId(Long postId);
}
