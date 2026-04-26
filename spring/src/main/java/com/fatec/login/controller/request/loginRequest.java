package com.fatec.login.controller.request;

public record loginRequest(
        String username,
        String password
) {
}
