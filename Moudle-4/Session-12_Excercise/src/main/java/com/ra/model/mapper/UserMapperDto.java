package com.ra.model.mapper;

import com.ra.model.dto.user.UserLoginResponse;
import com.ra.model.dto.user.UserRegisterRequest;
import com.ra.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapperDto {
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User toEntity(UserRegisterRequest request){
        if(request == null) return null;

        return User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .roles(request.getRoles())
                .build();
    }

    public UserLoginResponse toUserResponse(User user, String token){
        if(user == null) return null;

        return UserLoginResponse.builder()
                .email(user.getEmail())
                .accessToken(token)
                .build();
    }


}
