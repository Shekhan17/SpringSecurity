package com.sample.security.model.dto.auth;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String login;
    private String password;
}
