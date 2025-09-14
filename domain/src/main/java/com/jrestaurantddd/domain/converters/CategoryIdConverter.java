package com.jrestaurantddd.domain.converters;

import com.jrestaurantddd.domain.valueobjects.CategoryId;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class CategoryIdConverter implements AttributeConverter<CategoryId, UUID> {
    @Override
    public UUID convertToDatabaseColumn(CategoryId id) {
        return id != null ? id.getValue() : null;
    }

    @Override
    public CategoryId convertToEntityAttribute(UUID dbData) {
        return dbData != null ? new CategoryId(dbData) : null;
    }
}
