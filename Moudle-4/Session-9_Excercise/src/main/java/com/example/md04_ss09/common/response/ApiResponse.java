package com.example.md04_ss09.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
}
