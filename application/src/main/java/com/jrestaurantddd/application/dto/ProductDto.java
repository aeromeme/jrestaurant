package com.jrestaurantddd.application.dto;

import java.util.UUID;

public class ProductDto extends BaseProductDto {
    private UUID ProductId;
    private double priceAmount;
    private String priceCurrency;
    private boolean isActive;
    private UUID categoryId;
    private CategoryDto category;


    public UUID getProductId() { return ProductId; }
    public void setProductId(UUID ProductId) { this.ProductId = ProductId; }
    public double getPriceAmount() { return priceAmount; }
    public void setPriceAmount(double priceAmount) { this.priceAmount = priceAmount; }
    public String getPriceCurrency() { return priceCurrency; }
    public void setPriceCurrency(String priceCurrency) { this.priceCurrency = priceCurrency; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public UUID getCategoryId() { return categoryId; }
    public void setCategoryId(UUID categoryId) { this.categoryId = categoryId; }
    public CategoryDto getCategory() { return category; }
    public void setCategory(CategoryDto category) { this.category = category; }
}
