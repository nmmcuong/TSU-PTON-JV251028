package com.ra.controller;

import com.ra.model.dto.user.UserLoginRequest;
import com.ra.model.dto.user.UserRegisterRequest;
import com.ra.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerResponse(@Valid @RequestBody UserRegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginResponse(@Valid @RequestBody UserLoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }
}
