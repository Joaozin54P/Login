package com.fatec.login.model;

import com.fatec.login.model.enumerable.userRole;

import java.util.List;

public record user(
        String id,
        String username,
        String password,
        String email,
        List<userRole> roles,
        String clienteId
) {
}