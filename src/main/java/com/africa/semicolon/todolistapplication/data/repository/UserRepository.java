package com.africa.semicolon.todolistapplication.data.repository;

import com.africa.semicolon.todolistapplication.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
