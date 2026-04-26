package com.fatec.login.repository.orm;


import com.fatec.login.model.enumerable.userRole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
public record UserOrm(
        @Id
        String id,

        @Indexed
        String username,

        String password,
        String email,
        List<userRole> roles
) {
}