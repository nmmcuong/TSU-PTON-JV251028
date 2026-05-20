package com.example.session11.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String fullName;
    private String email;
    private String department;
    private String avatarUrl;
}
