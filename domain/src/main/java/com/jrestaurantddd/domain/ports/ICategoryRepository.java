package com.jrestaurantddd.domain.ports;

import com.jrestaurantddd.domain.entities.Category;
import com.jrestaurantddd.domain.valueobjects.CategoryId;
import java.util.List;

public interface ICategoryRepository {
    Category getById(CategoryId id);
    List<Category> getAll();
}
