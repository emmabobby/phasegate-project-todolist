package com.africa.semicolon.todolistapplication.data.repository;

import com.africa.semicolon.todolistapplication.data.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findTaskById(String id);

    Task findByTitle(String title);


//    Task findByTitle(String title);
}
