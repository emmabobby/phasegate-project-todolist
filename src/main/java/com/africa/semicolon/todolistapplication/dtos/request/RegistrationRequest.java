package com.africa.semicolon.todolistapplication.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegistrationRequest {
    private String username;
    private String password;
}
