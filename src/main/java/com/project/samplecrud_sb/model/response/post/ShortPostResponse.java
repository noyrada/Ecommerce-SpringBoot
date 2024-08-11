package com.project.samplecrud_sb.model.response.post;

import com.project.samplecrud_sb.model.entity.PostEntity;

import java.io.Serializable;

public class ShortPostResponse implements Serializable {
    private Long id;
    private String title;

    public ShortPostResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static ShortPostResponse fromEntity(PostEntity entity){
        return new ShortPostResponse(
                entity.getId(),
                entity.getTitle()
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
