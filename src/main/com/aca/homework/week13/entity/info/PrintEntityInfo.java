package com.aca.homework.week13.entity.info;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PrintEntityInfo implements PrintInfoStrategy {

    private final Object o;

    public PrintEntityInfo(Object o) {
        this.o = o;
    }

    @Override
    public String print() {
        String tableName = getTableName();
        String idFieldValue = getFieldValueAnnotatedAsId();
        Map<String, String> mapOfColumnNamesAndFieldNames = columnNamesAndFieldNames();
        StringBuilder sb = new StringBuilder();
        sb.append("table name is: ");
        sb.append(tableName);
        sb.append(", id is ");
        sb.append(idFieldValue);
        sb.append(", ");
        for (Map.Entry<String, String> entry : mapOfColumnNamesAndFieldNames.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" is ");
            sb.append(entry.getValue());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private String getTableName() {
        return o.getClass().getDeclaredAnnotation(Table.class).name();
    }


    private String getFieldValueAnnotatedAsId() {
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getDeclaredAnnotation(Id.class) != null) {
                return getValueOfField(field);
            }
        }
        throw new RuntimeException("No field in class " + o.getClass().getSimpleName() + " annotated as @Id.");
    }

    private Map<String, String> columnNamesAndFieldNames() {
        Map<String, String> map = new HashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getDeclaredAnnotation(Column.class) != null) {
                map.put(field.getDeclaredAnnotation(Column.class).name(), getValueOfField(field));
            }
        }
        return map;
    }

    private String getValueOfField(Field field) {
        try {
            return field.get(o).toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Class " + o.getClass().getSimpleName() + " does not have provided field " + field);
        }
    }


}
