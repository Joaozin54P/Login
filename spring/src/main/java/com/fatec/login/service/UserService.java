package com.fatec.login.service;

import com.fatec.login.model.user;
import com.fatec.login.repository.UserRepository;
import com.fatec.login.security.JwtSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurity jwtSecurity;

    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder,
                       JwtSecurity jwtSecurity) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtSecurity = jwtSecurity;
    }

    public user save(user user) {
        user novo = new user(
                null,
                user.username(),
                passwordEncoder.encode(user.password()),
                user.email(),
                user.roles(),
                null
        );

        return repository.save(novo);
    }

    public String login(String username, String password) {
        user usuario = repository.findByUsername(username);

        if (!passwordEncoder.matches(password, usuario.password())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return jwtSecurity.generateToken(usuario);
    }
}