package com.project.samplecrud_sb.model.entity;

import com.project.samplecrud_sb.infrastructure.model.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "post_comments")
public class PostCommentEntity extends BaseEntity {

    @Column(nullable = false,length = 255)
    private String comment;

    //many to one relational:
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id",nullable = false,referencedColumnName = "id")
    private PostEntity post;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommentEntity that = (PostCommentEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(comment, that.comment) && Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), comment, post);
    }
}
