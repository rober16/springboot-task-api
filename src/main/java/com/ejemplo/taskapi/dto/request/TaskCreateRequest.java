package com.ejemplo.taskapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateRequest {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Integer priority;

    @NotNull
    private Long userId;

    @NotNull
    private Long categoryId;
}