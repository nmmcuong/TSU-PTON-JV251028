package com.example.session11.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.session11.model.request.ActiveUserRequest;
import com.example.session11.model.request.LoginRequest;
import com.example.session11.model.request.MessageResponse;
import com.example.session11.model.request.RegisterRequest;
import com.example.session11.model.response.JwtResponse;
import com.example.session11.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest request) {
        JwtResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/active-user")
    public ResponseEntity<MessageResponse> activateUser(@Valid @RequestBody ActiveUserRequest request) {
        return ResponseEntity.ok(authService.activateUser(request));
    }
}
