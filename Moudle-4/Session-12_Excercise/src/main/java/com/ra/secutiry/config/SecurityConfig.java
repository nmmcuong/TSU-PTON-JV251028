package com.ra.secutiry.config;

import com.ra.secutiry.jwt.CustomAccessDeniedHandler;
import com.ra.secutiry.jwt.JwtAuthenticationEntryPoint;
import com.ra.secutiry.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Tắt CSRF vì dùng JWT
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Không dùng Session
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/register", "/api/auth/login").permitAll()// Cho phép đăng nhập/đăng ký tự do
                        .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/products/**").hasAnyRole("ADMIN", "STAFF")
                        .requestMatchers(HttpMethod.PUT,"/api/products/**").hasAnyRole("ADMIN", "STAFF")
                        .requestMatchers(HttpMethod.DELETE,"/api/products/**").hasAnyRole("ADMIN", "STAFF")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandler))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(entryPoint));

        // Thêm Filter JWT vào trước Filter xác thực mặc định
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt là chuẩn mã hóa mạnh, tự động thêm "salt" để chống hack
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
}
