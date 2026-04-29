package com.ejemplo.taskapi.dto.request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryUpdateRequest {
    private String name;
    private String description;
}
