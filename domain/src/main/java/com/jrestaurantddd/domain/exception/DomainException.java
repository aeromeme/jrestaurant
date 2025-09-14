package com.jrestaurantddd.domain.exception;

public class DomainException extends RuntimeException {
    private final String paramName;

    public DomainException(String message) {
        super(message);
        this.paramName = null;
    }

    public DomainException(String message, Throwable innerException) {
        super(message, innerException);
        this.paramName = null;
    }

    public DomainException(String message, String paramName) {
        super(message);
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }
}
