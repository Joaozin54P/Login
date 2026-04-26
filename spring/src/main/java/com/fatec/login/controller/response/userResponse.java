package com.fatec.login.controller.response;

import com.fatec.login.model.enumerable.userRole;

import java.util.List;

public record userResponse(
        String id,
        String username,
        String password,
        String email,
        List<userRole> roles
) {
}