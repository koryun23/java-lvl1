package com.aca.homework.week15.service.user;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final ConnectionFactory factory;

    public UserRepository(ConnectionFactory factory) {
        this.factory = factory;
    }

    public void save(User user) {
        Connection connection = factory.getObject();
        try {
            connection.createStatement().execute(SqlStatementGenerator.generateInsert(user));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Could not execute the query '%s'", SqlStatementGenerator.generateInsert(user)));
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class SqlStatementGenerator {
        private static String generateInsert(User user) {
            StringBuilder query = new StringBuilder();
            query.append("insert into ");
            query.append(tableName(user));
            query.append(" (");

            for (String columnName : columns(user)) {
                query.append(columnName);
                query.append(", ");
            }
            query.delete(query.length() - 2, query.length());
            query.append(") values (");
            query.append(String.format("'%s'", user.getName()));
            query.append(", ");
            query.append(String.format("'%s'", user.getUsername()));
            query.append(");");
            return query.toString();
        }

        private static List<String> columns(User user) {
            List<String> columns = new ArrayList<>();
            Field[] fields = user.getClass().getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getDeclaredAnnotations().length);
                if (field.getDeclaredAnnotation(Column.class) != null) {
                    columns.add(field.getDeclaredAnnotation(Column.class).name());
                }
            }
            return columns;
        }

        private static String tableName(User user) {
            return user.getClass().getDeclaredAnnotation(Table.class).name();
        }
    }
}
