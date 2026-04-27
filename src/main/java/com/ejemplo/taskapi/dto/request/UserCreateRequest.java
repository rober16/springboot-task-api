package com.ejemplo.taskapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserCreateRequest {
    @NotBlank
    private String username;

    private String email;

    @NotNull
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();
}
