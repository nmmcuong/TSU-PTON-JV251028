package com.example.md04_ss07.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 100, message = "Họ tên từ 5 đến 100 ký tự")
    private String fullName;

    @NotBlank(message = "Chuyên ngành không được để trống")
    private String major;

    @Min(value = 18, message = "Sinh viên phải 18 tuổi trở lên")
    private Integer age;

    @Min(value = 0, message = "Điểm GPA phải nằm trong khoảng 0 - 10")
    @Max(value = 10, message = "Điểm GPA phải nằm trong khoảng 0 - 10")
    private Double gpa;

    @Pattern(regexp = "^SV\\d{4}$", message = "Mã sinh viên phải theo định dạng: SVxxxx (với x là số tự nhiên từ 0 - 9)")
    private String studentCode;

    @Valid
    private ParentDTO parent;
}
