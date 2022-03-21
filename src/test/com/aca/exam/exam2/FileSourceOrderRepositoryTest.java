package com.aca.exam.exam2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

class FileSourceOrderRepositoryTest {
    private FileSourceOrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        orderRepository = new FileSourceOrderRepository(FileSourceUserRepository.of());
    }

    @Test
    public void testFindByIdWhenIdIsNotFound() throws FileNotFoundException {
        Assertions.assertNull(orderRepository.findById(10));
    }

    @Test
    public void testFindByIdWhenIdIsFound() throws FileNotFoundException {
        Assertions.assertNotNull(orderRepository.findById(5));
    }

    @Test
    public void testFindAllSize() throws FileNotFoundException {
        Assertions.assertEquals(9, orderRepository.findAll().size());
    }

    @Test
    public void testFindAllByUserId() throws FileNotFoundException {
        Assertions.assertEquals(
                List.of(
                        new Order(2, "kafka book", 25000, orderRepository.fetchUserByUsername("shawlinspire")),
                        new Order(5, "michael kors watch", 23000, orderRepository.fetchUserByUsername("shawlinspire")),
                        new Order(9, "picnic mat", 3000, orderRepository.fetchUserByUsername("shawlinspire"))
                ), orderRepository.findAllByUserId("shawlinspire")
        );
    }
}