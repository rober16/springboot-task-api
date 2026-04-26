package com.ejemplo.taskapi.repository;

import com.ejemplo.taskapi.model.Task;
import com.ejemplo.taskapi.model.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}