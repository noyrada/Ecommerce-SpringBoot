package com.project.samplecrud_sb.model.request.user;

import com.project.samplecrud_sb.model.entity.UserEntity;

import java.io.Serializable;

public class UserLoginRequest implements Serializable {

    private String username;

    public UserLoginRequest(String username) {
        this.username = username;
    }

    public UserEntity toEntity(){
        UserEntity user = new UserEntity();
        user.setUsername(this.username);
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
