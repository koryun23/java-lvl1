package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    private UserService testSubject;
    private DBReader reader;

    @BeforeEach
    public void init() {
        ConnectionFactory factory = new ConnectionFactory();
        testSubject = new UserService(new UserRepository(factory));
        reader = new DBReader(factory.getObject());
    }

    @Test
    public void testCreate() {
        int startSize = reader.readAll().size();
        Assertions.assertEquals(new User("JOHNNY", "john"), testSubject.create(new UserCreateParams("JOHNNY", "john")));
        int endSize = reader.readAll().size();
        Assertions.assertEquals(1, endSize - startSize);
        Assertions.assertEquals(new User("JOHNNY", "john"), reader.readAll().get(endSize - 1));
    }
}