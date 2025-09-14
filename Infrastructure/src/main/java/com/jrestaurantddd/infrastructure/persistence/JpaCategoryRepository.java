package com.jrestaurantddd.infrastructure.persistence;

import com.jrestaurantddd.domain.entities.Category;
import com.jrestaurantddd.domain.valueobjects.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category, CategoryId> {
    // JpaRepository provides CRUD methods
}
