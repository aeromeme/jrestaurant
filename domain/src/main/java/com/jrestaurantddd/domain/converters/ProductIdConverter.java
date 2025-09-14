package com.jrestaurantddd.domain.converters;
import com.jrestaurantddd.domain.valueobjects.ProductId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductIdConverter implements AttributeConverter<ProductId, String> {
    @Override
    public String convertToDatabaseColumn(ProductId id) {
        return id != null ? id.toString() : null;
    }
    @Override
    public ProductId convertToEntityAttribute(String dbData) {
        return dbData != null ? ProductId.fromString(dbData) : null;
    }
}
