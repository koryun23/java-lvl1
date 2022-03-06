package com.aca.homework.week8.product.repository;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(long id) {
        super("Product with id = " + id + " already exists.");
    }
}
