package com.jrestaurantddd.domain.ports;

import com.jrestaurantddd.domain.entities.Category;
import com.jrestaurantddd.domain.valueobjects.CategoryId;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ICategoryRepository {
    Category getById(CategoryId id);
    CompletableFuture<List<Category>> getAll();
}
