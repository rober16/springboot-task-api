package com.ejemplo.taskapi.service.impl;
import com.ejemplo.taskapi.dto.request.CategoryCreateRequest;
import com.ejemplo.taskapi.dto.response.CategoryResponse;
import com.ejemplo.taskapi.model.Category;
import com.ejemplo.taskapi.repository.CategoryRepository;
import com.ejemplo.taskapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse create(CategoryCreateRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        Category saved = categoryRepository.save(category);
        return mapToResponse(saved);
    }

    @Override
    public List<CategoryResponse> findAll() {

        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // =========================
    // MAPPER (Entidad → DTO)
    // =========================
    private CategoryResponse mapToResponse(Category category) {
        return CategoryResponse.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
}
