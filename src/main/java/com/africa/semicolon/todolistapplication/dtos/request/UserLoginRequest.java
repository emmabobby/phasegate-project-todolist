package com.africa.semicolon.todolistapplication.dtos.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String username;
    private String password;

}
