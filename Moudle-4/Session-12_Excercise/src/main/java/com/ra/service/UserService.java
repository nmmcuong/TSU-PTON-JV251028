package com.ra.service;

import com.ra.exception.BadRequestException;
import com.ra.model.dto.user.UserLoginRequest;
import com.ra.model.dto.user.UserLoginResponse;
import com.ra.model.dto.user.UserRegisterRequest;
import com.ra.model.entity.User;
import com.ra.model.mapper.UserMapperDto;
import com.ra.repository.UserRepository;
import com.ra.secutiry.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserMapperDto mapperDto;

    public String register(UserRegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new BadRequestException("Email đã tồn tại");
        }

        if(userRepository.existsByPhone(request.getPhone())){
            throw new BadRequestException("Số điện thoại đã tồn tại");
        }

        User user = mapperDto.toEntity(request);
        userRepository.save(user);
        return "Đăng ký thành công!";
    }

    public UserLoginResponse login(UserLoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        return  new UserLoginResponse("Đăng nhập thành công", request.getEmail(), jwt);
    }
}
