package com.jrestaurantddd.domain.ports;

import java.util.concurrent.CompletableFuture;

public interface IUnitOfWork {
    CompletableFuture<Void> saveChanges();
}
