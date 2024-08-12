//package com.africa.semicolon.todolistapplication.web;
//
//import com.africa.semicolon.todolistapplication.dtos.response.RegistrationResponse;
//import com.africa.semicolon.todolistapplication.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) {
//        RegistrationResponse response = userService.register(registrationRequest);
//        return ResponseEntity.ok().body(response);
//    }
//
//}
