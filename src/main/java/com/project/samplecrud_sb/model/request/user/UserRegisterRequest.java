package com.project.samplecrud_sb.model.request.user;

import com.project.samplecrud_sb.model.entity.UserEntity;
import com.project.samplecrud_sb.model.request.address.AddressRequest;

import java.io.Serializable;

public class UserRegisterRequest implements Serializable {

    private String username;

    private AddressRequest address;

    public UserRegisterRequest(String username, AddressRequest address) {
        this.username = username;
        this.address = address;
    }

    public AddressRequest getAddress() {
        return address;
    }

    public void setAddress(AddressRequest address) {
        this.address = address;
    }

    public UserRegisterRequest(String username) {
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
