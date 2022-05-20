package com.aca.homework.week15.sql.generate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SqlGenerator {

    public String generateInsert(User user) {
        StringBuilder query = new StringBuilder();
        query.append("\"insert into ");
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
        query.append(user.getAge());
        query.append(");\"");
        return query.toString();
    }

    private List<String> columns(User user) {
        List<String> columns = new ArrayList<>();
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getDeclaredAnnotation(Column.class) != null) {
                columns.add(field.getDeclaredAnnotation(Column.class).name());
            }
        }
        return columns;
    }

    private String tableName(User user) {
        return user.getClass().getDeclaredAnnotation(Table.class).name();
    }
}
