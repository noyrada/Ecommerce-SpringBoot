package com.project.samplecrud_sb.model.request.address;

import com.project.samplecrud_sb.model.entity.AddressEntity;
import com.project.samplecrud_sb.model.entity.UserEntity;

import java.io.Serializable;

public class AddressRequest implements Serializable {

    private String address;

    public AddressRequest(String address) {
        this.address = address;
    }

    public AddressEntity toEntity(UserEntity parentEntity){
        AddressEntity address = new AddressEntity();
        address.setAddress(this.address);
        address.setUser(parentEntity);
        return address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
