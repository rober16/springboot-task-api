package com.ejemplo.taskapi.dto.response;

import com.ejemplo.taskapi.model.enums.TaskStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Integer priority;

    private String username;
    private String categoryName;
}