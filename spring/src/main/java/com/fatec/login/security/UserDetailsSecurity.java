package com.fatec.login.security;

import com.fatec.login.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurity implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsSecurity(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new AuthUserDetails(user);
    }
}