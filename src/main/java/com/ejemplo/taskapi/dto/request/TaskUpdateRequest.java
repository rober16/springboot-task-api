package com.ejemplo.taskapi.dto.request;

import com.ejemplo.taskapi.model.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateRequest {

    private String title;
    private String description;
    private TaskStatus status;
    private Integer priority;
    private Boolean enabled;
}
