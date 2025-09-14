package com.jrestaurantddd.domain.ports;

import com.jrestaurantddd.domain.entities.Product;
import com.jrestaurantddd.domain.valueobjects.ProductId;

import java.util.List;

public interface IProductRepository {
    Product add(Product product);
    Product edit(Product product);
    List<Product> getAll();
    void delete(ProductId id);
    Product getById(ProductId id);
}
