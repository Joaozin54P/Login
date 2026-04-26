package com.fatec.login.repository;

import com.fatec.login.model.login;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface loginRepository extends MongoRepository<login, String> {
    Optional<login> findByUsername(String username);
}