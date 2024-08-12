package com.africa.semicolon.todolistapplication.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Setter
@Getter
public class User {
    private String id;
    private String username;
    private String password;
    private List<Task> tasks = new ArrayList<>();
    private boolean isLocked;

    }

