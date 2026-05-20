package com.example.session11.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    // Chiều dài 255 vì mật khẩu băm bằng BCrypt rất dài
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 20)
    private String role; // Ví dụ: "ROLE_ADMIN", "ROLE_USER"

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private boolean enabled = false; // Mặc định khóa

    @Column(name = "otp_code", length = 6)
    private String otpCode;

    @Column(name = "otp_expiration")
    private LocalDateTime otpExpiration;
}
