package com.project.samplecrud_sb.model.request.postComment;


import com.project.samplecrud_sb.model.entity.PostCommentEntity;
import java.io.Serializable;

public class UpdatePostCommentRequest implements Serializable {

    private String comment;

    public PostCommentEntity toEntity(){
        PostCommentEntity postComment = new PostCommentEntity();
        postComment.setComment(this.getComment());
        return postComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
