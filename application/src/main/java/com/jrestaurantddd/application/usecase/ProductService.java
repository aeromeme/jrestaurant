package com.jrestaurantddd.application.usecase;

import com.jrestaurantddd.application.dto.ProductDto;
import com.jrestaurantddd.application.mapper.ProductMapper;
import com.jrestaurantddd.domain.ports.IProductRepository;
import com.jrestaurantddd.domain.entities.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CompletableFuture<List<ProductDto>> getAllAsync() {
        return productRepository.getAll().thenApply(products ->
            products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList())
        );
    }
}
