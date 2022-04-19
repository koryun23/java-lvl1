package com.aca.homework.week15.repository.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getObject() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:7432/employee_repository", "postgres", null
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not connect to database");
        }
    }
}

