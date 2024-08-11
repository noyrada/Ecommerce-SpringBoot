package com.project.samplecrud_sb.model.response.postComment;

import com.project.samplecrud_sb.model.entity.PostCommentEntity;
import com.project.samplecrud_sb.model.response.post.ShortPostResponse;

import java.io.Serializable;

public class PostCommentResponse implements Serializable {

    private Long id;

    private String comment;

    private ShortPostResponse post;

    public static PostCommentResponse fromEntity(PostCommentEntity response){
        return new PostCommentResponse(response.getId(),response.getComment(),ShortPostResponse.fromEntity(response.getPost()));
    }

    public PostCommentResponse(Long id, String comment,ShortPostResponse post) {
        this.id = id;
        this.comment = comment;
        this.post = post;
    }

    public ShortPostResponse getPost() {
        return post;
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
