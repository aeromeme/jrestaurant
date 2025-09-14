package com.jrestaurantddd.application.dto;

import java.util.UUID;

public class ProductCreateDto extends BaseProductDto {
    private double priceAmount;
    private UUID categoryId;

    public double getPriceAmount() { return priceAmount; }
    public void setPriceAmount(double priceAmount) { this.priceAmount = priceAmount; }
    public UUID getCategoryId() { return categoryId; }
    public void setCategoryId(UUID categoryId) { this.categoryId = categoryId; }
}
