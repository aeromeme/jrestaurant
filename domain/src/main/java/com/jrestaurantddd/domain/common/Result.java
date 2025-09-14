package com.jrestaurantddd.domain.common;

/**
 * Result pattern interface for domain operations.
 */
public interface Result<T> {
    boolean isSuccess();
    boolean isFailure();
    T getValue();
    String getError();
}
