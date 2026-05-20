package com.example.session11.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/protected")
public class ProtectedController {

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getCurrentUser() {
        // Trình diễn cách lấy thông tin User từ Context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Bạn đã lọt qua được trạm kiểm soát JWT!");
        response.put("username", authentication.getName());
        response.put("authorities", authentication.getAuthorities());

        return ResponseEntity.ok(response);
    }
}
