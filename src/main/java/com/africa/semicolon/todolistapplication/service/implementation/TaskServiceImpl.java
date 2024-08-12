package com.africa.semicolon.todolistapplication.service.implementation;

import com.africa.semicolon.todolistapplication.data.models.Date;
import com.africa.semicolon.todolistapplication.data.models.Task;
import com.africa.semicolon.todolistapplication.data.repository.TaskRepository;
import com.africa.semicolon.todolistapplication.dtos.request.CreateTaskRequest;
import com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse;
import com.africa.semicolon.todolistapplication.service.TaskService;
import com.africa.semicolon.todolistapplication.utils.DateMapper;
import com.africa.semicolon.todolistapplication.utils.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;

@Service
@RequiredArgsConstructor

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;


    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        String day = createTaskRequest.getDueDate().getDay();
        String month = createTaskRequest.getDueDate().getMonth();
        String year = createTaskRequest.getDueDate().getYear();

        Date date = DateMapper.map(year, month, day);
        Task task = TaskMapper.map(createTaskRequest.getBody(), createTaskRequest.getTitle(), date);
        taskRepository.save(task);

        com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse createTaskResponse = new com.africa.semicolon.todolistapplication.dtos.response.CreateTaskResponse();
        createTaskResponse.setMessage("Successfully created task");
        return createTaskResponse;


    }

    @Override
    public void deleteTask(java.lang.String taskId) {
        Task task = taskRepository.findById(taskId).get();
        taskRepository.delete(task);

    }

    @Override
    public void completeTask(java.lang.String taskId) {
        Task task = taskRepository.findById(taskId).get();
        task.setComplete(true);
    }

    @Override
    public void deleteAllTasks() {
        Task task = taskRepository.findAll().get(0);
        taskRepository.delete(task);
    }

    @Override
    public Task findByTitle(java.lang.String title) {
        return taskRepository.findByTitle(title);
    }


}
