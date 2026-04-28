package com.ejemplo.taskapi.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequest {
    @NotBlank
    private String name;

    private String description;
}
