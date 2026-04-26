package com.fatec.login.controller;

import com.fatec.login.controller.request.loginRequest;
import com.fatec.login.controller.response.authResponse;
import com.fatec.login.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fatec/login")
public class authController {

    private final UserService service;

    public authController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/v1/auth")
    public authResponse login(@RequestBody loginRequest request) {
        String token = service.login(request.username(), request.password());
        return new authResponse(token);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/auth/forget/{username}")
    public String forgetPassword(@PathVariable("username") String username) {
        return "Olá " + username + " enviamos sua senha para o seu email";
    }
}