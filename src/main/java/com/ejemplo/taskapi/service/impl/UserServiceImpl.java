package com.ejemplo.taskapi.service.impl;
import com.ejemplo.taskapi.dto.request.UserCreateRequest;
import com.ejemplo.taskapi.dto.response.UserResponse;
import com.ejemplo.taskapi.model.User;
import com.ejemplo.taskapi.repository.UserRepository;
import com.ejemplo.taskapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserCreateRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User saved = userRepository.save(user);

        return mapToResponse(saved);
    }

    @Override
    public List<UserResponse> findAll() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // =========================
    // MAPPER (Entidad → DTO)
    // =========================
    private UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
