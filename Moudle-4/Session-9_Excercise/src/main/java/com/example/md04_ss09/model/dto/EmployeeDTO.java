package com.example.md04_ss09.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    @NotBlank(message = "Tên không được trống")
    private String fullName;

    @NotBlank(message = "Email không được trống")
    @Email(message = "Phải đúng định dạng")
    private String email;

    @NotBlank(message = "Số điện thoại không được trống")
    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "Số điện thoại không đúng định dạng Việt Nam")
    private String phone;

    @NotNull
    @Min(value = 5000000)
    private Double salary ;

    @NotNull(message = "Không để trống")
    private Integer department_id;

    private String avatarUrl;
}
