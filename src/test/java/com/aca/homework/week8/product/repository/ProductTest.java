package com.aca.homework.week8.product.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void testEqualsWhenOneProductIsNull() {
        Product product1 = new Product(0, "book");
        Product product2 = null;
        assertNotEquals(product1, product2);
    }

    @Test
    public void testEqualsTrue() {
        Product product1 = new Product(1, "phone");
        Product product2 = new Product(1, "phone");
        assertEquals(product1, product2);
    }

    @Test
    public void testEqualsFalse() {
        Product product1 = new Product(2, "pen");
        Product product2 = new Product(3, "pencil");
        assertNotEquals(product1, product2);
    }

    @Test
    public void testToString() {
        assertEquals("Product id: 5, name: laptop", new Product(5, "laptop").toString());
    }
}