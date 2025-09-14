package com.jrestaurantddd.domain.converters;
import com.jrestaurantddd.domain.valueobjects.ProductId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class ProductIdConverter implements AttributeConverter<ProductId, UUID> {
    @Override
    public UUID convertToDatabaseColumn(ProductId id) {
        return id != null ? id.getValue() : null;
    }
    @Override
    public ProductId convertToEntityAttribute(UUID dbData) {
        return dbData != null ? new ProductId(dbData) : null;
    }
}
