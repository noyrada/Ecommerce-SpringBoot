package com.project.samplecrud_sb.model.entity;

import com.project.samplecrud_sb.infrastructure.model.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tags")
public class TagsEntity extends BaseEntity {

    @Column(length = 255,nullable = false,unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagsEntity that = (TagsEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }
}
