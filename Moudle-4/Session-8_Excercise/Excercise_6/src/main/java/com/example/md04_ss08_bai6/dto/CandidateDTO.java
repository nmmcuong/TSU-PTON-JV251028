package com.example.md04_ss08_bai6.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDTO {
    @NotBlank(message = "Hãy nhập tên")
    @Size(min = 5, max = 20, message = "Tên có độ dài 5 - 20 ký tự")
    private String fullName;

    @NotBlank(message = "Hãy nhập email")
    @Email(message = "Nhập email đúng định dạng (VD: abc123@gmail.com)")
    private String email;

    @NotEmpty(message = "Hãy nhập kỹ năng")
    private List<String> skills = new ArrayList<>();
}
