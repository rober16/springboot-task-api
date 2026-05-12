package com.ejemplo.taskapi.service;

import com.ejemplo.taskapi.dto.request.LoginRequest;
import com.ejemplo.taskapi.dto.request.RegisterRequest;
import com.ejemplo.taskapi.dto.response.AuthResponse;

public interface AuthService {

    void register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}