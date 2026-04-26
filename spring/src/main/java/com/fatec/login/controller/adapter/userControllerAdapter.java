package com.fatec.login.controller.adapter;

import com.fatec.login.controller.request.userRequest;
import com.fatec.login.model.user;
import com.fatec.login.model.enumerable.userRole;

import java.util.List;

public class userControllerAdapter {

    private userControllerAdapter() {
    }

    public static user cast(userRequest request) {

        List<userRole> roles = request.roles();

        return new user(
                null,
                request.username(),
                request.password(),
                request.email(),
                roles,
                null
        );
    }
}