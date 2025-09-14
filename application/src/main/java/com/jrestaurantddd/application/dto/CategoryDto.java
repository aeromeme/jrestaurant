package com.jrestaurantddd.application.dto;

import java.util.UUID;

public class CategoryDto {
    private UUID CategoryId;
    private String name;
    private String description;
    
    public CategoryDto() {}

    public CategoryDto(UUID CategoryId, String name, String description) {
        this.CategoryId = CategoryId;
        this.name = name;
        this.description = description;
    }

    public UUID getCategoryId() { return CategoryId; }
    public void setCategoryId(UUID CategoryId) { this.CategoryId = CategoryId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

