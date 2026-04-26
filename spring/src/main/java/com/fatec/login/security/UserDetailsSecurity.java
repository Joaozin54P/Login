package com.fatec.login.security;

import com.fatec.login.model.login;
import com.fatec.login.repository.loginRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSecurity implements UserDetailsService {

    private final loginRepository repository;

    public UserDetailsSecurity(loginRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        login user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new AuthUserDetails(user);
    }
}