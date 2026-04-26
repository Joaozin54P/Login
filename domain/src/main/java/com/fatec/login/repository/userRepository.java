package com.fatec.login.repository;

import com.fatec.login.model.user;

public interface userRepository {
    user save(user user);

    user findByUsername(String username);
}