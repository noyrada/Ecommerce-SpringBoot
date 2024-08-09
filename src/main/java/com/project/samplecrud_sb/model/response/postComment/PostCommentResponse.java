package com.project.samplecrud_sb.model.response.postComment;

import com.project.samplecrud_sb.model.entity.PostCommentEntity;

import java.io.Serializable;

public class PostCommentResponse implements Serializable {

    private Long id;

    private String comment;

    public static PostCommentResponse fromEntity(PostCommentEntity response){
        return new PostCommentResponse(response.getId(),response.getComment());
    }

    public PostCommentResponse(Long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
