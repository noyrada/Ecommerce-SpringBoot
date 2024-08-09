package com.project.samplecrud_sb.model.response.user;

import com.project.samplecrud_sb.model.entity.UserEntity;

import java.io.Serializable;

public class UserLoginResponse implements Serializable {

    private Long id;

    private String username;

    public UserLoginResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public static UserLoginResponse fromEntity(UserEntity entity) {
        return new UserLoginResponse(entity.getId(), entity.getUsername());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
