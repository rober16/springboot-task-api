package com.ejemplo.taskapi.service;

import com.ejemplo.taskapi.dto.request.TaskCreateRequest;
import com.ejemplo.taskapi.dto.request.TaskUpdateRequest;
import com.ejemplo.taskapi.dto.response.TaskResponse;
import com.ejemplo.taskapi.model.enums.TaskStatus;

import java.util.List;

public interface TaskService {

    TaskResponse create(TaskCreateRequest request);

    List<TaskResponse> findAll();

    TaskResponse findById(Long id);

    List<TaskResponse> findByStatus(TaskStatus status);

    List<TaskResponse> findByUserId(Long userId);

    TaskResponse update(Long id, TaskUpdateRequest request);

    void delete(Long id);
}