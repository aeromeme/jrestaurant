package com.jrestaurantddd.infrastructure.unitofwork;

import com.jrestaurantddd.domain.ports.IUnitOfWork;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.concurrent.CompletableFuture;

@Component
public class JpaUnitOfWork implements IUnitOfWork {
    @Override
    @Transactional
    public CompletableFuture<Void> saveChanges() {
        // In Spring, @Transactional ensures changes are committed.
        // For async, just return a completed future.
        return CompletableFuture.completedFuture(null);
    }
}
