package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.model.entity.UserEntity;
import com.project.samplecrud_sb.model.request.user.UserRegisterRequest;
import com.project.samplecrud_sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserRegisterRequest request) throws Exception{
        UserEntity user = this.userService.register(request);
        return ResponseEntity.ok(user);
    }
}
