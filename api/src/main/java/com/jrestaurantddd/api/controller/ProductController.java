package com.jrestaurantddd.api.controller;

import com.jrestaurantddd.application.usecase.ProductService;
import com.jrestaurantddd.application.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public CompletableFuture<List<ProductDto>> getAllProducts() {
        return productService.getAllAsync();
    }
}
