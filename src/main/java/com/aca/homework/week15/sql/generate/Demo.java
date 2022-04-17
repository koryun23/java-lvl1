package com.aca.homework.week15.sql.generate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:7432/aca", "postgres", null);

        UserCrudRepository repo = new UserCrudRepository(connection);
        repo.save(new User("John", 12));
    }
}
