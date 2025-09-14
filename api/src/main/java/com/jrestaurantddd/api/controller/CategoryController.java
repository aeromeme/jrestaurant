package com.jrestaurantddd.api.controller;

import com.jrestaurantddd.application.usecase.GetAllCategoriesService;
import com.jrestaurantddd.application.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final GetAllCategoriesService getAllCategoriesService;

    @Autowired
    public CategoryController(GetAllCategoriesService getAllCategoriesService) {
        this.getAllCategoriesService = getAllCategoriesService;
    }

    @GetMapping
    public CompletableFuture<List<CategoryDto>> getAllCategories() {
        return getAllCategoriesService.execute();
    }
}
