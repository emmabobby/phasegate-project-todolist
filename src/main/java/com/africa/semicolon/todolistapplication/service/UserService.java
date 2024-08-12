package com.africa.semicolon.todolistapplication.service;

import com.africa.semicolon.todolistapplication.data.models.User;
import com.africa.semicolon.todolistapplication.dtos.request.CreateTaskRequest;
import com.africa.semicolon.todolistapplication.dtos.request.RegistrationRequest;
import com.africa.semicolon.todolistapplication.dtos.request.UserLoginRequest;
import com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse;
import com.africa.semicolon.todolistapplication.dtos.response.RegistrationResponse;

public interface UserService {
    RegistrationResponse register(RegistrationRequest registrationRequest);
    CreateTaskResponse createTask(CreateTaskRequest createTaskRequest);

    User login(UserLoginRequest userLoginRequest);

    User lock(String lexus);
}
