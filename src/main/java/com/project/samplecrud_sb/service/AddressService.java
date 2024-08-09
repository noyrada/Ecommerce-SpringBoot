package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.repository.AddressRepository;
import com.project.samplecrud_sb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }


//    public AddressEntity register(AddressRequest req) throws Exception{
//
//    }

}
