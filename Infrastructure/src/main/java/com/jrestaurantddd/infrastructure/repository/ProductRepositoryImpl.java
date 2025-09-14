package com.jrestaurantddd.infrastructure.repository;

import com.jrestaurantddd.domain.entities.Product;
import com.jrestaurantddd.domain.valueobjects.ProductId;
import com.jrestaurantddd.domain.ports.IProductRepository;
import com.jrestaurantddd.infrastructure.persistence.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository {
    private final JpaProductRepository jpaProductRepository;

    @Autowired
    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product add(Product product) {
        return jpaProductRepository.save(product);
    }

    @Override
    public Product edit(Product product) {
        return jpaProductRepository.save(product);
    }

    @Override
    public CompletableFuture<List<Product>> getAll() {
        return CompletableFuture.supplyAsync(() ->
            Collections.unmodifiableList(jpaProductRepository.findAll())
        );
    }

    @Override
    public void delete(ProductId id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public CompletableFuture<Product> getById(ProductId id) {
        return CompletableFuture.supplyAsync(() ->
            jpaProductRepository.findById(id).orElse(null)
        );
    }
}
