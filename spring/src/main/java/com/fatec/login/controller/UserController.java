package com.fatec.login.controller;

import com.fatec.login.controller.adapter.userControllerAdapter;
import com.fatec.login.controller.request.userRequest;
import com.fatec.login.controller.response.userResponse;
import com.fatec.login.model.user;
import com.fatec.login.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fatec/login")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/user/save")
    public userResponse save(@RequestBody userRequest request) {

        user save = service.save(userControllerAdapter.cast(request));

        return new userResponse(
                save.id(),
                save.username(),
                save.password(),
                save.email(),
                save.roles()
        );
    }
}