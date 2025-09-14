package com.jrestaurantddd.infrastructure.repository;

import com.jrestaurantddd.domain.entities.Category;
import com.jrestaurantddd.domain.valueobjects.CategoryId;
import com.jrestaurantddd.infrastructure.persistence.JpaCategoryRepository;
import com.jrestaurantddd.domain.ports.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    private final JpaCategoryRepository jpaCategoryRepository;

    @Autowired
    public CategoryRepositoryImpl(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public Category getById(CategoryId id) {
        return jpaCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public CompletableFuture<List<Category>> getAll() {
        return CompletableFuture.supplyAsync(() ->
            Collections.unmodifiableList(jpaCategoryRepository.findAll())
        );
    }
}
