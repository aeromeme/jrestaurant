package com.jrestaurantddd.application.usecase;

import com.jrestaurantddd.application.dto.CategoryDto;
import com.jrestaurantddd.application.mapper.CategoryMapper;
import com.jrestaurantddd.domain.ports.ICategoryRepository;
import com.jrestaurantddd.domain.entities.Category;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class GetAllCategoriesService {
    private final ICategoryRepository categoryRepository;

    public GetAllCategoriesService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CompletableFuture<List<CategoryDto>> execute() {
        return categoryRepository.getAll().thenApply(categories ->
            categories.stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList())
        );
    }
}
