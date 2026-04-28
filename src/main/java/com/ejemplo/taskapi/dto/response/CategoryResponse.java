package com.ejemplo.taskapi.dto.response;
import lombok.Builder;
import lombok.Getter;
import jakarta.persistence.Column;

@Getter
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
}
