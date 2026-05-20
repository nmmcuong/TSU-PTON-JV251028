package com.example.session11.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ActiveUserRequest {
    @NotBlank private String email;
    @NotBlank private String otp;
}
