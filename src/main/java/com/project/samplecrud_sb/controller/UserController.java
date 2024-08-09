package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.UserEntity;
import com.project.samplecrud_sb.model.request.user.UserRegisterRequest;
import com.project.samplecrud_sb.model.response.user.UserRegisterResponse;
import com.project.samplecrud_sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //find all filed from db:
    @GetMapping
    public ResponseEntity<List<UserRegisterResponse>> findAll(){
        List<UserRegisterResponse> data = this.userService.findAll().stream().map(UserRegisterResponse::fromEntity).toList();
        return ResponseEntity.ok(data);
    }
    //find by id:
    @GetMapping("/{id}")
    public ResponseEntity<UserRegisterResponse> findOne(@PathVariable Long id)throws NotFoundException {
        UserEntity data = this.userService.findOne(id);
        return ResponseEntity.ok(UserRegisterResponse.fromEntity(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRegisterResponse> update(@PathVariable Long id, @RequestBody UserRegisterRequest request)throws Exception{
        UserEntity data = this.userService.update(id, request);
        return ResponseEntity.ok(UserRegisterResponse.fromEntity(data));
    }

}
