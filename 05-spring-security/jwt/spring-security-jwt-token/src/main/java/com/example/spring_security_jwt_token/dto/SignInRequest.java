package com.example.spring_security_jwt_token.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
