package com.aca.homework.week8.product.repository;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
