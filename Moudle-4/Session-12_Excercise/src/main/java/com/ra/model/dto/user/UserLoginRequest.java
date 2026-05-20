package com.ra.model.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRequest {
    @NotBlank(message = "Hãy nhập email")
    @Email(message = "Email không đúng định dạng")
    @Size(min = 6, message = "Tối thiểu có 6 ký tự")
    private String email;
    @NotBlank(message = "Hãy nhập password")
    @Size(min = 6, message = "Tối thiểu có 6 ký tự")
    private String password;
}
