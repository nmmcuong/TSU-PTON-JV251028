package com.example.md04_ss07.dto;

import com.example.md04_ss07.validation.ViettelPhone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParentDTO {
    @NotBlank(message = "Tên phụ huynh không được để trống")
    @Pattern(regexp = "^[A-Z].*", message = "Tên phụ huynh phải viết chữ cái đầu")
    private String name;

    @ViettelPhone
    private String phone;
}
