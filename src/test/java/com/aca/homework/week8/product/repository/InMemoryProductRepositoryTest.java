package com.aca.homework.week8.product.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryProductRepositoryTest {
    private InMemoryProductRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new InMemoryProductRepository();
    }

    @Test
    public void testSaveWhenProductIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(null);
            }
        });
    }

    @Test
    public void testSaveWhenProductDoesNotExist() {
        testSubject.save(new Product(0, "pen"));
        assertEquals(1, testSubject.getNumOfProducts());
    }

    @Test
    public void testSaveWhenProductAlreadyExist() {
        testSubject.save(new Product(0, "pen"));

        assertThrows(ProductAlreadyExistsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(new Product(0, "pen"));
            }
        });
    }

    @Test
    public void testFindByIdWhenProductDoesNotExist() {
        assertNull(testSubject.findById(0));
    }

    @Test
    public void testFindByIdWhenProductExists() {
        testSubject.save(new Product(0, "pen"));
        assertEquals(new Product(0, "pen"), testSubject.findById(0));
    }

    @Test
    public void testGetByIdWhenProductDoesNotExist() {
        assertThrows(ProductNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.getById(0);
            }
        });
    }

    @Test
    public void testGetByIdWhenProductExists() {
        Product product = new Product(0, "pen");
        testSubject.save(product);
        assertEquals(new Product(0, "pen"), testSubject.getById(0));
    }


}