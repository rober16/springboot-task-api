package com.ejemplo.taskapi.service;
import com.ejemplo.taskapi.dto.request.CategoryCreateRequest;
import com.ejemplo.taskapi.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryCreateRequest request);

    List<CategoryResponse> findAll();
}
