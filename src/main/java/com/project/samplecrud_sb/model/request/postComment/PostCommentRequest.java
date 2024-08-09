package com.project.samplecrud_sb.model.request.postComment;


import com.project.samplecrud_sb.model.entity.PostCommentEntity;

import java.io.Serializable;

public class PostCommentRequest implements Serializable {

    private String comment;
    private Long postId;

    public PostCommentEntity toEntity(){
        PostCommentEntity postComment = new PostCommentEntity();
        postComment.setComment(this.getComment());
        return postComment;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
