package com.ra.model.dto.user;

import com.ra.model.entity.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegisterRequest {
    @NotBlank(message = "Hãy nhập email")
    @Email(message = "Email không đúng định dạng")
    @Size(min = 6, message = "Tối thiểu có 6 ký tự")
    private String email;
    @NotBlank(message = "Hãy nhập password")
    @Size(min = 6, message = "Tối thiểu có 6 ký tự")
    private String password;
    @NotBlank(message = "Hãy nhập số điện thoại")
    @Size(min = 11, max = 13, message = "Số điện thoại độ dài từ 11 - 13 ký tự")
    private String phone;
    @NotNull(message = "Hãy nhập roles")
    private Roles roles;
}
