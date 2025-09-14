package com.jrestaurantddd.application.dto;

import java.util.UUID;

public class ProductUpdateDto extends BaseProductDto {
    private UUID ProductId;
    private double priceAmount;
    private UUID categoryId;

    public UUID getProductId() { return ProductId; }
    public void setProductId(UUID ProductId) { this.ProductId = ProductId; }
    public double getPriceAmount() { return priceAmount; }
    public void setPriceAmount(double priceAmount) { this.priceAmount = priceAmount; }
    public UUID getCategoryId() { return categoryId; }
    public void setCategoryId(UUID categoryId) { this.categoryId = categoryId; }
}
