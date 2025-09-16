package com.jrestaurantddd.domain.common;

public interface IResult<T> {
    boolean isSuccess();
    String getMessage();
    T getData();
}
