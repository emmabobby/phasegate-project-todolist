package com.africa.semicolon.todolistapplication.service;

import com.africa.semicolon.todolistapplication.data.models.Task;
import com.africa.semicolon.todolistapplication.dtos.request.CreateTaskRequest;
import com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse;

public interface TaskService {

    CreateTaskResponse createTask(CreateTaskRequest createTaskRequest);
    void deleteTask(String taskId);
    void completeTask(String taskId);
    void deleteAllTasks();
    Task findByTitle(String title);
}


