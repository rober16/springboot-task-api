package com.ejemplo.taskapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateRequest {

    private String title;
    private String description;
    private Integer priority;
    private Long userId;
    private Long categoryId;
}