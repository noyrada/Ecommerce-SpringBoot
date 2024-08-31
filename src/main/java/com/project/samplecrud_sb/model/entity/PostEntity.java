package com.project.samplecrud_sb.model.entity;

import com.project.samplecrud_sb.infrastructure.model.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity<Long> {

    @Column(length = 50,nullable = false)
    private String title;

    @Column(length = 500,nullable = false)
    private String description;

    //One to Many Relational:
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<PostCommentEntity> postComments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(postComments, that.postComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), title, description, postComments);
    }
}
