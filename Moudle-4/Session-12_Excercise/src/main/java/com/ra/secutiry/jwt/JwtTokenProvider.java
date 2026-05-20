package com.ra.secutiry.jwt;

import com.ra.secutiry.model.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private final String JWT_SECRET = "chuoi_bi_mat_rat_dai_va_kho_doan_123456";
    private final long JWT_EXPIRATION = 604800000L; // 7 ngày

    // Tạo JWT từ thông tin UserPrincipal
    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername()) // Lưu Email/Username vào subject
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    // Lấy Username từ Token
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JWT_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Kiểm tra Token hợp lệ
    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(JWT_SECRET.getBytes()).build().parseClaimsJws(authToken);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
