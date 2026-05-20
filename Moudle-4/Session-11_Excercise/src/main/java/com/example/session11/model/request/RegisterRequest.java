package com.example.session11.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RegisterRequest {
    @NotBlank private String username;
    @NotBlank @Email private String email;
    @NotBlank private String password;
}
