package com.project.samplecrud_sb.model.response.address;

import java.io.Serializable;

public class AddressResponse implements Serializable {

    private Long id;

    private String address;

    public AddressResponse(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
