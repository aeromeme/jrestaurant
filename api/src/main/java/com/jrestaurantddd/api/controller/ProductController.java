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
import java.net.URI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get all products", responses = {
        @ApiResponse(responseCode = "200", description = "List of products",
            content = @Content(mediaType = "application/json", schema = @Schema(type = "array", implementation = ProductDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad request",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
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

    @Operation(summary = "Add a product", responses = {
        @ApiResponse(responseCode = "201", description = "Created product",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))),
        @ApiResponse(responseCode = "400", description = "Bad request",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    @PostMapping
    public CompletableFuture<ResponseEntity<?>> addProduct(@RequestBody ProductCreateDto productCreateDto) {
        return productService.addProduct(productCreateDto)
            .thenApply(result -> {
                if (result.isSuccess()) {
                    return ResponseEntity.created(URI.create("/products/" + result.getData().getProductId())).body(result.getData());
                } else {
                    return ResponseEntity.badRequest().body(result.getMessage());
                }
            });
    }
}
