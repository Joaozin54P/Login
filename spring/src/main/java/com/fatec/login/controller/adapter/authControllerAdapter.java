package com.fatec.login.controller.adapter;

import com.fatec.login.controller.request.loginRequest;
import com.fatec.login.model.login;

public class authControllerAdapter {

    private authControllerAdapter() {
    }

    public static login cast(loginRequest request) {
        return new login(
                request.username(),
                request.password()
        );
    }
}