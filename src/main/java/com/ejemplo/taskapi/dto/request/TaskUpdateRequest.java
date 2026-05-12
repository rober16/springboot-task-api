package com.ejemplo.taskapi.dto.request;

import com.ejemplo.taskapi.model.enums.TaskStatus;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateRequest {
    @Size(min = 1, max = 150, message = "El título debe tener entre 1 y 150 caracteres")
    private String title;

    private String description;

    private TaskStatus status;

    private Integer priority;
}
