package com.project.samplecrud_sb.controller.backend;

import com.project.samplecrud_sb.model.entity.UserEntity;
import com.project.samplecrud_sb.model.request.user.UserLoginRequest;
import com.project.samplecrud_sb.model.request.user.UserRegisterRequest;
import com.project.samplecrud_sb.model.response.user.UserLoginResponse;
import com.project.samplecrud_sb.model.response.user.UserRegisterResponse;
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
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) throws Exception{
        UserEntity user = this.userService.register(request);
        return ResponseEntity.ok(UserRegisterResponse.fromEntity(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) throws Exception {
        UserEntity user = this.userService.login(request);
        return ResponseEntity.ok(UserLoginResponse.fromEntity(user));
    }
}
