package com.africa.semicolon.todolistapplication.service.implementation;

import com.africa.semicolon.todolistapplication.data.models.Date;
import com.africa.semicolon.todolistapplication.data.models.User;
import com.africa.semicolon.todolistapplication.data.repository.UserRepository;
import com.africa.semicolon.todolistapplication.dtos.request.CreateTaskRequest;
import com.africa.semicolon.todolistapplication.dtos.request.RegistrationRequest;
import com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse;
import com.africa.semicolon.todolistapplication.dtos.response.RegistrationResponse;
import com.africa.semicolon.todolistapplication.service.TaskService;
import com.africa.semicolon.todolistapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceImplTest {
    @Autowired
    private TaskService taskService;


}