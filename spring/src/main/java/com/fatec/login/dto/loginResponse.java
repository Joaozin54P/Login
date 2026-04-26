package com.fatec.login.dto;

public record loginResponse(
        String id,
        String username,
        String password,
        String role,
        String email
) {
}
