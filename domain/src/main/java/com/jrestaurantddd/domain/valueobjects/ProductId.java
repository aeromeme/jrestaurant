package com.jrestaurantddd.domain.valueobjects;
import java.util.UUID;

public final class ProductId {
    public static ProductId newId() {
        return new ProductId(UUID.randomUUID());
    }
    private final UUID value;

    public ProductId(UUID value) {
        if (value == null) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }
        this.value = value;
    }

    public static ProductId fromString(String uuidString) {
        return new ProductId(UUID.fromString(uuidString));
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return value.equals(productId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
