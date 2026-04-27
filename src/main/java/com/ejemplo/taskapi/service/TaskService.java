package com.ejemplo.taskapi.service;

import com.ejemplo.taskapi.dto.request.TaskCreateRequest;
import com.ejemplo.taskapi.dto.request.TaskUpdateRequest;
import com.ejemplo.taskapi.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse create(TaskCreateRequest request);

    List<TaskResponse> findAll();

    TaskResponse findById(Long id);

    TaskResponse update(Long id, TaskUpdateRequest request);

    void delete(Long id);
}