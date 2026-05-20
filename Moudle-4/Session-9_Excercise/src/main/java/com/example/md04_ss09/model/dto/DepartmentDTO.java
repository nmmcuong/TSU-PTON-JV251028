package com.example.md04_ss09.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DepartmentDTO {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 50, message = "Tên có độ dài từ 5-50 ký tự")
    private String name;

    @Size(max = 100, message = "Tối đa 100 ký tự")
    private String description;
}
