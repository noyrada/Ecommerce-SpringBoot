package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.exceptions.AlreadyExistException;
import com.project.samplecrud_sb.exceptions.BadRequestException;
import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.UserEntity;
import com.project.samplecrud_sb.model.request.user.UserLoginRequest;
import com.project.samplecrud_sb.model.request.user.UserRegisterRequest;
import com.project.samplecrud_sb.repository.AddressRepository;
import com.project.samplecrud_sb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

            //return result;
            return this.userRepository.findById(user.getId()).orElseThrow(()->
                    new NotFoundException("Not found!"));

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //update user method:
    public UserEntity update(Long id, UserRegisterRequest req)throws Exception{
        //validate data has or not
        UserEntity foundUser = this.userRepository.findById(id).orElseThrow(()->
                new NotFoundException("User not found!"));

        //validate if username already exist than throws error:
        if (!Objects.equals(foundUser.getUsername(),req.getUsername()))
            if (this.userRepository.existsByUsername(req.getUsername()))
                throw new AlreadyExistException("Username is already taken");

        //prepare data:
        foundUser.setUsername(req.getUsername());

        if (req.getAddress()== null)
            foundUser.setAddress(null);
        else
            foundUser.getAddress().setAddress(req.getAddress().getAddress());

        try {
            //save master
            this.userRepository.save(foundUser);

            //save children
            this.addressRepository.save(foundUser.getAddress());

            //return result;
            return this.userRepository.findById(foundUser.getId()).orElseThrow(()->
                    new NotFoundException("Not found!"));

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //login user:
    public UserEntity login(UserLoginRequest req) throws Exception{
        return this.userRepository.findByUsername(req.getUsername()).orElseThrow(()-> new
                BadRequestException("Invalid Username"));
    }

    //find all data from db:
    public List<UserEntity> findAll(){
        return this.userRepository.findAll();
    }

    //find by one data by id:
    public UserEntity findOne(Long id) throws NotFoundException{
        return this.userRepository.findById(id).orElseThrow(()-> new
                NotFoundException("Not found!"));
    }





}
