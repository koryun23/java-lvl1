package com.aca.homework.week15.sql.generate;

import java.lang.reflect.Field;

public class SqlGenerator {
    public String generateInsert(User user) {
        String query = String.format("\"insert into %s (%s, %s) values ('%s', %s);\"",
                tableName(user),
                column(field(user, "name")),
                column(field(user, "age")),
                user.getName(),
                user.getAge());

        return query;
    }

    private String column(Field field) {
        return field.getDeclaredAnnotation(Column.class).name();
    }

    private String tableName(User user) {
        return user.getClass().getDeclaredAnnotation(Table.class).name();
    }

    private Field field(User user, String name) {
        try {
            return user.getClass().getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("No field with name " + name + " in class " + user.getClass().getSimpleName());
        }
    }
}
