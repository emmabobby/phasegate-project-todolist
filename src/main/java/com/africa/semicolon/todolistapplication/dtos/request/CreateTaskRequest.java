package com.africa.semicolon.todolistapplication.dtos.request;

import com.africa.semicolon.todolistapplication.data.models.Date;
import lombok.Data;

@Data
public class CreateTaskRequest {
    private String title;
    private String body;
    private Date dueDate;
}
