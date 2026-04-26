package com.fatec.login.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logins")
public record login(
        @Id String id,
        String username,
        String password,
        String role,
        String email,
        String clienteId
) {
}