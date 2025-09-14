package com.jrestaurantddd.infrastructure.persistence;

import com.jrestaurantddd.domain.entities.Product;
import com.jrestaurantddd.domain.valueobjects.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, ProductId> {
    // JpaRepository provides CRUD methods
}
