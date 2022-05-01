package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserRepositoryTest {
    private UserRepository testSubject;
    private DBReader reader;

    @BeforeEach
    public void init() {
        ConnectionFactory factory = new ConnectionFactory();
        testSubject = new UserRepository(new ConnectionFactory());
        reader = new DBReader(factory.getObject());
    }

    @Test
    public void testSaveOnce() {
        int startingSize = reader.readAll().size();
        testSubject.save(new User("johnny123", "John"));
        int endSize = reader.readAll().size();
        Assertions.assertEquals(1, endSize - startingSize);
        Assertions.assertEquals(new User("johnny123", "John"), reader.readAll().get(endSize - 1));
    }


}