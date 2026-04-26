package com.fatec.login.dto;

public record loginRequest(
        String username,
        String password,
        String role,
        String email
) {
}
