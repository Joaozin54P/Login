package com.fatec.login.repository;

import com.fatec.login.model.user;
import com.fatec.login.repository.adapter.UserRepositoryImplAdapter;
import com.fatec.login.repository.client.UserRepositoryWithMongodb;
import com.fatec.login.repository.orm.UserOrm;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryWithMongodb repository;

    public UserRepositoryImpl(UserRepositoryWithMongodb repository) {
        this.repository = repository;
    }

    @Override
    public user save(user user) {
        UserOrm orm = repository.save(UserRepositoryImplAdapter.cast(user));
        return UserRepositoryImplAdapter.cast(orm);
    }

    @Override
    public user findByUsername(String username) {
        return repository.findByUsername(username)
                .map(UserRepositoryImplAdapter::cast)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}