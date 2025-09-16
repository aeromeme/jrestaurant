package com.jrestaurantddd.api.controller;

import com.jrestaurantddd.application.usecase.ProductService;
import com.jrestaurantddd.application.dto.ProductDto;
import com.jrestaurantddd.application.dto.ProductCreateDto;
import com.jrestaurantddd.domain.common.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public CompletableFuture<ResponseEntity<?>> getAllProducts() {
        return productService.getAllAsync()
            .thenApply(result -> {
                if (result.isSuccess()) {
                    return ResponseEntity.ok(result.getData());
                } else {
                    return ResponseEntity.badRequest().body(result.getMessage());
                }
            });
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<?>> addProduct(@RequestBody ProductCreateDto productCreateDto) {
        return productService.addProduct(productCreateDto)
            .thenApply(result -> {
                if (result.isSuccess()) {
                    return ResponseEntity.ok(result.getData());
                } else {
                    return ResponseEntity.badRequest().body(result.getMessage());
                }
            });
    }
}
