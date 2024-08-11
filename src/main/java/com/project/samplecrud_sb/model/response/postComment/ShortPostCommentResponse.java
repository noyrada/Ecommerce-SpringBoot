package com.project.samplecrud_sb.model.response.postComment;

import com.project.samplecrud_sb.model.entity.PostCommentEntity;

import java.io.Serializable;

public class ShortPostCommentResponse implements Serializable {

    private Long id;

    private String comment;

    public static ShortPostCommentResponse fromEntity(PostCommentEntity response){
        return new ShortPostCommentResponse(response.getId(),response.getComment());
    }

    public ShortPostCommentResponse(Long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public Long getId() {
        return id;
    }
}
