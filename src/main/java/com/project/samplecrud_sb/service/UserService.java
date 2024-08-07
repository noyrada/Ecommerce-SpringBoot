package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.exceptions.AlreadyExistException;
import com.project.samplecrud_sb.model.entity.UserEntity;
import com.project.samplecrud_sb.model.request.user.UserRegisterRequest;
import com.project.samplecrud_sb.repository.AddressRepository;
import com.project.samplecrud_sb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public UserEntity register(UserRegisterRequest req) throws Exception{
        //prepare data to parent's entity:
        UserEntity request = req.toEntity();

        //if username already exist then throw errors:
        if (this.userRepository.existsByUsername(request.getUsername()))
            throw new AlreadyExistException("Username is already taken");

        try {
            //save parent entity:
            UserEntity user = this.userRepository.save(request);

            //save child entity:
            this.addressRepository.save(req.getAddress().toEntity(user));
            return user;

        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

}
