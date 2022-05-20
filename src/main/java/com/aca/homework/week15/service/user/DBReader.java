package com.aca.homework.week15.service.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DBReader {
    private Connection connection;

    public DBReader(Connection connection) {
        this.connection = connection;
    }

    public List<User> readAll() {
        ResultSet res = getResultSet();

        List<User> users = new LinkedList<>();

        while(true) {
            try {
                if (!res.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            users.add(new User(getColumnValue(res, "name"), getColumnValue(res, "username")));
        }

        return users.size() == 0 ? Collections.emptyList() : Collections.unmodifiableList(users);
    }

    private ResultSet getResultSet() {
        try {
            return connection.createStatement().executeQuery("select * from USERS;");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not execute the query 'select * from USERS;'");
        }
    }

    private String getColumnValue(ResultSet res, String columnName) {
        try {
            return res.getString(columnName);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not retrieve the value of column " + columnName);
        }
    }
}
