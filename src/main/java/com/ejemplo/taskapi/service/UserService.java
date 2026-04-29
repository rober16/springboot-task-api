package com.ejemplo.taskapi.service;

import com.ejemplo.taskapi.dto.request.UserCreateRequest;
import com.ejemplo.taskapi.dto.request.UserUpdateRequest;
import com.ejemplo.taskapi.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserCreateRequest request);

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse update(Long id, UserUpdateRequest request);

    void delete(Long id);
}
