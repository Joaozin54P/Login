package com.fatec.login.repository.adapter;

import com.fatec.login.model.user;
import com.fatec.login.repository.orm.UserOrm;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRepositoryImplAdapter {

    private UserRepositoryImplAdapter() {
    }

    public static user cast(UserOrm orm) {
        return new user(
                orm.id(),
                orm.username(),
                orm.password(),
                orm.email(),
                orm.roles(),
                null
        );
    }

    public static user cast(UserOrm orm, PasswordEncoder passwordEncoder) {
        return new user(
                orm.id(),
                orm.username(),
                passwordEncoder.encode(orm.password()),
                orm.email(),
                orm.roles(),
                null
        );
    }

    public static UserOrm cast(user user) {
        return new UserOrm(
                user.id(),
                user.username(),
                user.password(),
                user.email(),
                user.roles()
        );
    }
}