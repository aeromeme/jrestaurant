package com.jrestaurantddd.application.mapper;

import com.jrestaurantddd.application.dto.ProductDto;
import com.jrestaurantddd.domain.entities.Product;


public class ProductMapper {
    public static ProductDto toDto(Product product) {
        if (product == null) return null;
        ProductDto dto = new ProductDto();
        dto.setProductId(product.getId().getValue());
        dto.setName(product.getName());
        dto.setPriceAmount(product.getPrice().getAmount());
        dto.setPriceCurrency(product.getPrice().getCurrency());
        dto.setStock(product.getStock());
        dto.setActive(product.isActive());
        dto.setCategoryId(product.getCategory().getId().getValue());
        dto.setCategory(product.getCategory() != null ? CategoryMapper.toDto(product.getCategory()) : null);
        return dto;
    }

    
}
