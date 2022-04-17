package com.aca.homework.week15.sql.generate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class UserCrudRepositoryTest {

    @Test
    public void testInsertIntoRepository() {
        UserCrudRepository repo = null;
        try {
            repo = new UserCrudRepository(DriverManager.getConnection("jdbc:postgresql://127.0.0.1:7432/aca", "postgres", null));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        repo.save(new User("John", 12));
    }
}