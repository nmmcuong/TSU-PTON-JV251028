package com.example.session11.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.session11.exception.DuplicateResourceException;
import com.example.session11.exception.ResourceNotFoundException;
import com.example.session11.model.User;
import com.example.session11.model.request.ActiveUserRequest;
import com.example.session11.model.request.LoginRequest;
import com.example.session11.model.request.MessageResponse;
import com.example.session11.model.request.RegisterRequest;
import com.example.session11.model.response.JwtResponse;
import com.example.session11.repository.UserRepository;
import com.example.session11.security.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    public JwtResponse login(LoginRequest request) {
        // Thực hiện xác thực, nếu sai thông tin, hàm này sẽ tự động ném ra
        // BadCredentialsException
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        String username = authentication.getName();
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER");

        String token = jwtProvider.generateToken(username, role);

        return new JwtResponse(token, "Bearer", username);
    }

    @Transactional
    public MessageResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException("Username đã tồn tại.");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email đã được sử dụng.");
        }

        // 1. Tạo mã OTP ngẫu nhiên 6 số
        String otp = String.format("%06d", new Random().nextInt(999999));

        // 2. Lưu User mới (Mặc định enabled = false)
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // BẮT BUỘC HASH PASSWORD
        user.setRole("ROLE_USER");
        user.setEnabled(false);
        user.setOtpCode(otp);
        user.setOtpExpiration(LocalDateTime.now().plusMinutes(5));

        userRepository.save(user);

        // 3. Gửi Mail (Nếu lỗi, @Transactional sẽ Rollback xóa User khỏi DB)
        mailService.sendMail(user.getEmail(), otp);

        return new MessageResponse("Đăng ký thành công! Vui lòng kiểm tra email để lấy mã OTP.");
    }

    @Transactional
    public MessageResponse activateUser(ActiveUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy tài khoản với email này."));

        if (user.isEnabled()) {
            throw new IllegalArgumentException("Tài khoản này đã được kích hoạt.");
        }

        if (user.getOtpCode() == null || !user.getOtpCode().equals(request.getOtp())) {
            throw new IllegalArgumentException("Mã OTP không chính xác.");
        }

        if (user.getOtpExpiration().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Mã OTP đã hết hạn. Vui lòng yêu cầu mã mới.");
        }

        // Kích hoạt thành công
        user.setEnabled(true);
        user.setOtpCode(null);
        user.setOtpExpiration(null);

        // Trạng thái Managed Entity sẽ tự động Update xuống DB

        return new MessageResponse("Kích hoạt tài khoản thành công! Bạn có thể đăng nhập ngay bây giờ.");
    }
}