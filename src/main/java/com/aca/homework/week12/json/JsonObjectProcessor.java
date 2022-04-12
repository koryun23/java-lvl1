package com.aca.homework.week12.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class JsonObjectProcessor {

    public String process(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        setAccessibleAllFields(fields, true);
        return buildJsonObjectFromFields(fields, o);
    }

    private String buildJsonObjectFromFields(Field[] fields, Object o) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Field field : fields) {
            sb.append(format(field.getDeclaredAnnotation(JsonProperty.class).value()));
            sb.append(": ");
            sb.append(format(getValueOfField(o, field)));
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("}");
        return sb.toString();
    }

    private String format(Object obj) {
        return '"' + obj.toString() + '"';
    }

    private Object getValueOfField(Object o, Field field) {
        try {
            return field.get(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Object " + o + " does not have field " + field);
        }
    }

    private void setAccessibleAllFields(Field[] fields, boolean flag) {
        for (Field field : fields) {
            field.setAccessible(flag);
        }
    }

}
