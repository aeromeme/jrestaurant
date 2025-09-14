package com.jrestaurantddd.application.mapper;

import com.jrestaurantddd.application.dto.CategoryDto;
import com.jrestaurantddd.domain.entities.Category;

public class CategoryMapper {
    public static CategoryDto toDto(Category category) {
        if (category == null) return null;
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(category.getId().getValue());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

}
