package com.ejemplo.taskapi.controller;

import com.ejemplo.taskapi.dto.request.LoginRequest;
import com.ejemplo.taskapi.dto.request.RegisterRequest;
import com.ejemplo.taskapi.dto.response.AuthResponse;
import com.ejemplo.taskapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}