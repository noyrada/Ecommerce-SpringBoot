package com.project.samplecrud_sb.model.response.user;

import com.project.samplecrud_sb.model.entity.CategoryEntity;
import com.project.samplecrud_sb.model.entity.UserEntity;
import com.project.samplecrud_sb.model.request.address.AddressRequest;
import com.project.samplecrud_sb.model.response.address.AddressResponse;
import com.project.samplecrud_sb.model.response.category.CategoryResponse;

import java.io.Serializable;

public class UserRegisterResponse implements Serializable {

    private Long id;

    private String username;

    private AddressResponse address;

    public AddressResponse getAddress() {
        return address;
    }

    public UserRegisterResponse(Long id, String username, AddressResponse address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
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

    public static UserRegisterResponse fromEntity(UserEntity entity){
        AddressResponse addr = new AddressResponse(entity.getAddress().getId(),entity.getAddress().getAddress());
        return new UserRegisterResponse(
                entity.getId(),
                entity.getUsername(),
                addr
        );
    }
}
