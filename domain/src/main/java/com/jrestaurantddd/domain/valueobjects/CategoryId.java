package com.jrestaurantddd.domain.valueobjects;
import java.util.UUID;

public final class CategoryId {
    private final UUID value;

    public CategoryId(UUID value) {
        if (value == null) {
            throw new IllegalArgumentException("CategoryId cannot be null");
        }
        this.value = value;
    }

    public static CategoryId newId() {
        return new CategoryId(UUID.randomUUID());
    }

    public static CategoryId fromString(String uuidString) {
        return new CategoryId(UUID.fromString(uuidString));
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryId categoryId = (CategoryId) o;
        return value.equals(categoryId.value);
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
