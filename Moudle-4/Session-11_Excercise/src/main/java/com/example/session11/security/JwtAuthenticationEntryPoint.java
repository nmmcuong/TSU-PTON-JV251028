package com.example.session11.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, 
                         HttpServletResponse response, 
                         AuthenticationException authException) throws IOException, ServletException {
        
        // Cấu hình Header cho Response là JSON
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // Lấy câu thông báo chi tiết mà ta đã nhét vào request bên Filter
        String errorMessage = (String) request.getAttribute("JWT_ERROR");
        if (errorMessage == null) {
            errorMessage = "Unauthorized: Bạn cần đăng nhập để truy cập tài nguyên này.";
        }

        // Tạo cục JSON bằng Map
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", errorMessage);
        body.put("path", request.getServletPath());
        body.put("timestamp", LocalDateTime.now().toString());

        // Dùng ObjectMapper của Jackson để parse Map thành chuỗi JSON và nhét vào Response
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}
