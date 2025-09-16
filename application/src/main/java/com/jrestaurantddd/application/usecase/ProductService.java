package com.jrestaurantddd.application.usecase;

import com.jrestaurantddd.application.dto.ProductCreateDto;
import com.jrestaurantddd.application.dto.ProductDto;
import com.jrestaurantddd.application.mapper.ProductMapper;
import com.jrestaurantddd.domain.ports.IProductRepository;
import com.jrestaurantddd.domain.ports.ICategoryRepository;
import com.jrestaurantddd.domain.ports.IUnitOfWork;
import com.jrestaurantddd.domain.entities.Product;
import com.jrestaurantddd.domain.entities.Category;
import com.jrestaurantddd.domain.valueobjects.CategoryId;
import com.jrestaurantddd.domain.common.IResult;
import com.jrestaurantddd.domain.common.Result;
import com.jrestaurantddd.domain.exception.DomainException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    private final IUnitOfWork unitOfWork;

    public ProductService(IProductRepository productRepository, ICategoryRepository categoryRepository, IUnitOfWork unitOfWork) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfWork = unitOfWork;
    }

    public CompletableFuture<Result<List<ProductDto>>> getAllAsync() {
        try {
            return productRepository.getAll().thenApply(products ->
                Result.success(products.stream()
                    .map(ProductMapper::toDto)
                    .collect(Collectors.toList()))
            );
    } catch (DomainException ex) {
            return CompletableFuture.completedFuture(Result.failure(ex.getMessage()));
        } catch (Exception ex) {
            throw ex;
        }
    }

    public CompletableFuture<Result<ProductDto>> addProduct(ProductCreateDto productDto) {
        try {
            CategoryId categoryId = CategoryId.fromString(productDto.getCategoryId().toString());
            Category category = categoryRepository.getById(categoryId);
            if (category == null) {
                return CompletableFuture.completedFuture(Result.failure("Invalid category ID"));
            }
            Product product = new Product(
                productDto.getName(),
                new com.jrestaurantddd.domain.valueobjects.Money(productDto.getPriceAmount(), "USD"),
                productDto.getStock(),
                true, // default active
                category
            );
            productRepository.add(product);
            var data = unitOfWork.saveChanges().thenApply(v -> {
                ProductDto dto = ProductMapper.toDto(product);
                return Result.success(dto);
            });
            return data;
    } catch (DomainException ex) {
            return CompletableFuture.completedFuture(Result.failure(ex.getMessage()));
        } catch (Exception ex) {
            throw ex;
        }

    }
}
