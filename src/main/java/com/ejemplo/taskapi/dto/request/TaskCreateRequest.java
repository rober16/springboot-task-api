package com.ejemplo.taskapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateRequest {
    @NotBlank(message = "El título es obligatorio")
    private String title;

    private String description;

    @NotNull(message = "La prioridad es obligatoria")
    private Integer priority;

    @NotNull(message = "El userId es obligatorio")
    private Long userId;

    @NotNull(message = "El categoryId es obligatorio")
    private Long categoryId;
}