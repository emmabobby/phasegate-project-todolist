package com.africa.semicolon.todolistapplication.service.implementation;

import com.africa.semicolon.todolistapplication.data.models.Task;
import com.africa.semicolon.todolistapplication.data.models.User;
import com.africa.semicolon.todolistapplication.data.repository.UserRepository;
import com.africa.semicolon.todolistapplication.dtos.request.CreateTaskRequest;
import com.africa.semicolon.todolistapplication.dtos.request.RegistrationRequest;
import com.africa.semicolon.todolistapplication.dtos.request.UserLoginRequest;
import com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse;
import com.africa.semicolon.todolistapplication.dtos.response.RegistrationResponse;
import com.africa.semicolon.todolistapplication.exceptions.InvalidCredentialsException;
import com.africa.semicolon.todolistapplication.exceptions.UserAlreadyExistException;
import com.africa.semicolon.todolistapplication.exceptions.UserNotFoundException;
import com.africa.semicolon.todolistapplication.service.TaskService;
import com.africa.semicolon.todolistapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    private final TaskService taskService;

    @Override
    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        User user = new User();
        User foundUser = userRepository.findByUsername(registrationRequest.getUsername());
        if (foundUser != null) {
            throw new UserAlreadyExistException("user already exist");
        } else{
            user.setUsername(registrationRequest.getUsername());
            user.setPassword(registrationRequest.getPassword());
        }
        userRepository.save(user);

        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setMessage("Successfully registered");
        return registrationResponse;
    }

    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        return taskService.createTask(createTaskRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User foundUser = userRepository.findByUsername(userLoginRequest.getUsername());
        if (foundUser == null) {
            throw new UserNotFoundException("user not found");
        } else {

            if (foundUser.getUsername().equals(userLoginRequest.getUsername()) &&
                    foundUser.getPassword().equals(userLoginRequest.getPassword())) {
                foundUser.setLocked(false);
            } else {
                throw new InvalidCredentialsException("Incorrect credentials!");
            }
        }
        return foundUser;
    }

    @Override
    public User lock(String username) {
        User foundUser = userRepository.findByUsername(username);
        foundUser.setLocked(true);
        userRepository.save(foundUser);
        return foundUser;
    }

}