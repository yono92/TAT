package com.duties.tat.jwt;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";


    // 생성자에서 accessToken만 받도록 변경
    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
