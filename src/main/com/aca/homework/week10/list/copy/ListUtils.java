package com.aca.homework.week10.list.copy;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    private ListUtils() {
    }

    public static <T> List<T> copy(List<T> list) {
        List<T> copy = new ArrayList<>();
        for (T item : list) {
            copy.add(item);
        }
        return copy;
    }
}
