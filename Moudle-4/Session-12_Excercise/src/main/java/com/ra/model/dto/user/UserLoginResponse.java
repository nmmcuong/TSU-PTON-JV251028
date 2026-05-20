package com.ra.model.dto.user;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResponse {
    private String message;
    private String email;
    private String accessToken;
}
