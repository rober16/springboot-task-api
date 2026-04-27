package com.ejemplo.taskapi.service.impl;

import com.ejemplo.taskapi.dto.request.TaskCreateRequest;
import com.ejemplo.taskapi.dto.request.TaskUpdateRequest;
import com.ejemplo.taskapi.dto.response.TaskResponse;
import com.ejemplo.taskapi.model.Category;
import com.ejemplo.taskapi.model.Task;
import com.ejemplo.taskapi.model.User;
import com.ejemplo.taskapi.model.enums.TaskStatus;
import com.ejemplo.taskapi.repository.CategoryRepository;
import com.ejemplo.taskapi.repository.TaskRepository;
import com.ejemplo.taskapi.repository.UserRepository;
import com.ejemplo.taskapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public TaskResponse create(TaskCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(TaskStatus.PENDING);
        task.setUser(user);
        task.setCategory(category);

        Task saved = taskRepository.save(task);

        return mapToResponse(saved);
    }

    @Override
    public List<TaskResponse> findAll() {

        return taskRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TaskResponse findById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        return mapToResponse(task);
    }

    @Override
    public TaskResponse update(Long id, TaskUpdateRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        if (request.getTitle() != null) {
            task.setTitle(request.getTitle());
        }

        if (request.getDescription() != null) {
            task.setDescription(request.getDescription());
        }

        if (request.getStatus() != null) {
            task.setStatus(request.getStatus());
        }

        if (request.getPriority() != null) {
            task.setPriority(request.getPriority());
        }

        Task updated = taskRepository.save(task);

        return mapToResponse(updated);
    }

    @Override
    public void delete(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarea no encontrada");
        }

        taskRepository.deleteById(id);
    }

    // =========================
    // MAPPER (Entidad → DTO)
    // =========================
    private TaskResponse mapToResponse(Task task) {

        return TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .username(task.getUser().getUsername())
                .categoryName(task.getCategory().getName())
                .build();
    }
}