package com.jrestaurantddd.domain.entities;
import jakarta.persistence.*;

import com.jrestaurantddd.domain.converters.CategoryIdConverter;
import com.jrestaurantddd.domain.exception.DomainException;
import com.jrestaurantddd.domain.valueobjects.CategoryId;

/**
 * Category entity representing a product category in the system.
 * JPA annotations are grouped and commented for clarity.
 */
@Entity
@Table(name = "Categories")
public class Category {
    // Primary Key
    @Id
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "Id", columnDefinition = "uniqueidentifier"))
    private CategoryId id;

    // Category name mapped to 'Name' column
    @Column(name = "Name", nullable = false)
    private String name;

    // Category description mapped to 'Description' column
    @Column(name = "Description")
    private String description;

    // Protected no-arg constructor for JPA
    protected Category() {}

    // Business constructor
    public Category(String name, String description) {
        if (name == null || name.isEmpty()) {
            throw new DomainException("Category name cannot be null or empty");
        }
        this.id = CategoryId.newId();
        this.name = name;
        this.description = description;
    }

    // Getters
    public CategoryId getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
