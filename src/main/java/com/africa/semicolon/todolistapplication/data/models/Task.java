package com.africa.semicolon.todolistapplication.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Task {
    private String id;
    private String title;
    private String body;
    private Date dueDate;
    private boolean isComplete;

}
