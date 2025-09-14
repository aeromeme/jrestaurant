package com.jrestaurantddd.domain.converters;

import com.jrestaurantddd.domain.valueobjects.CategoryId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryIdConverter implements AttributeConverter<CategoryId, String> {
    @Override
    public String convertToDatabaseColumn(CategoryId id) {
        return id != null ? id.toString() : null;
    }

    @Override
    public CategoryId convertToEntityAttribute(String dbData) {
        return dbData != null ? CategoryId.fromString(dbData) : null;
    }
}
