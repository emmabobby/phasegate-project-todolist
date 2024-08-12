package com.africa.semicolon.todolistapplication.utils;

import com.africa.semicolon.todolistapplication.data.models.Date;
import com.africa.semicolon.todolistapplication.data.models.Task;

public class TaskMapper {
    public static Task map(String title, String body, Date dueDate){
        Task task = new Task();
        task.setTitle(title);
        task.setBody(body);
        task.setDueDate(dueDate);
        return task;
    }
}
