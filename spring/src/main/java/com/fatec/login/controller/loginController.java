package com.fatec.login.controller;

import com.fatec.login.dto.loginRequest;
import com.fatec.login.dto.loginResponse;
import com.fatec.login.model.login;
import com.fatec.login.service.loginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class loginController {

    private final loginService service;

    public loginController(loginService service) {
        this.service = service;
    }

    @PostMapping
    public loginResponse salvar(@RequestBody loginRequest request) {
        login novoLogin = new login(
                null,
                request.username(),
                request.password(),
                request.role(),
                request.email(),
                null
        );

        login salvo = service.salvar(novoLogin);

        return new loginResponse(
                salvo.id(),
                salvo.username(),
                salvo.password(),
                salvo.role(),
                salvo.email()
        );
    }

    @GetMapping
    public List<loginResponse> listar() {
        return service.listar()
                .stream()
                .map(user -> new loginResponse(
                        user.id(),
                        user.username(),
                        user.password(),
                        user.role(),
                        user.email()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/auth")
    public String auth(@RequestBody loginRequest request) {
        return service.realizarLogin(request.username(), request.password());
    }

    @PutMapping("/{id}")
    public loginResponse atualizar(@PathVariable String id, @RequestBody loginRequest request) {
        login novo = new login(
                null,
                request.username(),
                request.password(),
                request.role(),
                request.email(),
                null
        );

        login atualizado = service.atualizar(id, novo);

        return new loginResponse(
                atualizado.id(),
                atualizado.username(),
                atualizado.password(),
                atualizado.role(),
                atualizado.email()
        );
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        service.deletar(id);
        return "Deletado";
    }
}