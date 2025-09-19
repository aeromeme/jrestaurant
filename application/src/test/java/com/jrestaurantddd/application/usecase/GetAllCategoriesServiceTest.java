package com.jrestaurantddd.application.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import static org.junit.jupiter.api.Assertions.*;
import com.jrestaurantddd.domain.ports.ICategoryRepository;
import com.jrestaurantddd.application.dto.CategoryDto;
import com.jrestaurantddd.domain.entities.Category;
import com.jrestaurantddd.domain.valueobjects.CategoryId;

@DisplayName("GetAllCategoriesService Tests")
public class GetAllCategoriesServiceTest {

    @Test
    @DisplayName("Execute should return list of category DTOs")
    public void testExecuteReturnsCategoryDtos() {
        // Arrange
        ICategoryRepository mockRepo = Mockito.mock(ICategoryRepository.class);
        Category category = new Category("Test Category", "Test Description");
        List<Category> categories = List.of(category);
        Mockito.when(mockRepo.getAll())
               .thenReturn(CompletableFuture.completedFuture(categories));

        GetAllCategoriesService service = new GetAllCategoriesService(mockRepo);

        // Act
        List<CategoryDto> result = service.execute().join();

        // Assert
        assertNotNull(result, "Result should not be null");
        assertFalse(result.isEmpty(), "Result should not be empty");
        assertEquals(1, result.size(), "Should return one category");
        CategoryDto dto = result.get(0);
        assertEquals("Test Category", dto.getName(), "Category name should match");
    }
}
