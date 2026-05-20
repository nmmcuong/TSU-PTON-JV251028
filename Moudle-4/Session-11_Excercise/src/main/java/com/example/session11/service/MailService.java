package com.example.session11.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendMail(String toEmail, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Mã xác thực tài khoản Hệ thống Doanh nghiệp");
        // Format nội dung cho chuyên nghiệp
        message.setText("Chào bạn,\n\nMã OTP kích hoạt tài khoản của bạn là: " + otp
                + "\nMã này có hiệu lực trong 5 phút.\n\nTrân trọng.");

        mailSender.send(message);
    }
}
