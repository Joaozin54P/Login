package com.fatec.login.controller.request;

import com.fatec.login.model.enumerable.userRole;

import java.util.List;

public record userRequest(
        String username,
        String password,
        String email,
        List<userRole> roles,
        String clienteId
) {
}