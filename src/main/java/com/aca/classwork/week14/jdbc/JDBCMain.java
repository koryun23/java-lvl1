package com.aca.classwork.week14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMain {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:8080/aca", "postgres", null
        );

        connection.createStatement().execute("insert into users (name, age) values ('test', 18)");

        ResultSet resultSet = connection.createStatement().executeQuery("select * from users");
    }
}
