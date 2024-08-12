package com.africa.semicolon.todolistapplication.service;

import com.africa.semicolon.todolistapplication.data.models.Date;
import com.africa.semicolon.todolistapplication.data.models.User;
import com.africa.semicolon.todolistapplication.data.repository.UserRepository;
import com.africa.semicolon.todolistapplication.dtos.request.CreateTaskRequest;
import com.africa.semicolon.todolistapplication.dtos.request.RegistrationRequest;
import com.africa.semicolon.todolistapplication.dtos.request.UserLoginRequest;
import com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse;
import com.africa.semicolon.todolistapplication.dtos.response.RegistrationResponse;
import com.africa.semicolon.todolistapplication.exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }


    //    private static RegistrationRequest registrationRequest (String username, String password){
//        RegistrationRequest registrationRequest = new RegistrationRequest();
//        registrationRequest.setUsername(username);
//        registrationRequest.setPassword(password);
//        return registrationRequest;
//    }
//
//    @Test
//    public void testAddUser() {
//        RegistrationRequest registrationRequest = registrationRequest("John", "password");
//        RegistrationResponse response = userService.register(registrationRequest);
//        assertNotNull(response);
    @Test
    public void testThatNewUserCanRegister() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername("Veli");
        registrationRequest.setPassword("password");
        RegistrationResponse response = userService.register(registrationRequest);

        User veli = userRepository.findByUsername(registrationRequest.getUsername());
        assertNotNull(response);
        assertEquals("Veli", veli.getUsername());
    }
    @Test
    public void testThatNewUserCanNotRegisterTwice() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername("lexus");
        registrationRequest.setPassword("12345");
        RegistrationResponse response = userService.register(registrationRequest);

        User veli = userRepository.findByUsername(registrationRequest.getUsername());
        assertNotNull(response);
        assertEquals("lexus", veli.getUsername());

        RegistrationRequest secondRegistrationRequest = new RegistrationRequest();
        secondRegistrationRequest.setUsername("lexus");
        secondRegistrationRequest.setPassword("12345");
//        RegistrationResponse secondRegistrationResponse = userService.register(secondRegistrationRequest);

//        assertNotNull(secondRegistrationResponse);
        assertThrows(UserAlreadyExistException.class, () -> userService.register(secondRegistrationRequest));
    }

    @Test
    public void testThatAUserCanLogin() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername("lexus");
        registrationRequest.setPassword("12345");
        RegistrationResponse response = userService.register(registrationRequest);

        User veli = userRepository.findByUsername(registrationRequest.getUsername());
        assertNotNull(response);
        assertEquals("lexus", veli.getUsername());

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("lexus");
        userLoginRequest.setPassword("12345");
        User loggedInUser = userService.login(userLoginRequest);

        assertFalse(loggedInUser.isLocked());

    }

    @Test
    public void testThatAUserCanLogout() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername("lexus");
        registrationRequest.setPassword("12345");
        RegistrationResponse response = userService.register(registrationRequest);

        User veli = userRepository.findByUsername(registrationRequest.getUsername());
        assertNotNull(response);
        assertEquals("lexus", veli.getUsername());

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("lexus");
        userLoginRequest.setPassword("12345");
        User loggedInUser = userService.login(userLoginRequest);

        assertFalse(loggedInUser.isLocked());

        User loggedOutUser = userService.lock("lexus");
        assertTrue(loggedOutUser.isLocked());
    }

    @Test
    public void testThatAUserCanCreateTask() {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername("lexus");
        registrationRequest.setPassword("12345");
        RegistrationResponse response = userService.register(registrationRequest);

        User veli = userRepository.findByUsername(registrationRequest.getUsername());
        assertNotNull(response);
        assertEquals("lexus", veli.getUsername());

        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("lexus");
        userLoginRequest.setPassword("12345");
        User loggedInUser = userService.login(userLoginRequest);

        assertFalse(loggedInUser.isLocked());

        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTitle("rise of semicolon");
        createTaskRequest.setBody("message");

        Date date = new Date();
        date.setDay("15");
        date.setMonth("August");
        date.setYear("2024");

        createTaskRequest.setDueDate(date);
        CreateTaskResponse createTaskResponse = taskService.createTask(createTaskRequest);

        assertNotNull(createTaskResponse);
    }
}