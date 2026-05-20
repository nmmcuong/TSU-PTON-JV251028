package com.example.session11.model.request;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateDTO {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, message = "Tên nhân viên phải có ít nhất 5 ký tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Định dạng email không hợp lệ")
    private String email;

    @NotBlank(message = "Phòng ban không được để trống")
    private String department;

    private MultipartFile avatarFile;
}
