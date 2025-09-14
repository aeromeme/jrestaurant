package com.jrestaurantddd.domain.ports;

import com.jrestaurantddd.domain.entities.Product;
import com.jrestaurantddd.domain.valueobjects.ProductId;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IProductRepository {
    Product add(Product product);
    Product edit(Product product);
    CompletableFuture<List<Product>> getAll();
    void delete(ProductId id);
    CompletableFuture<Product> getById(ProductId id);
}
