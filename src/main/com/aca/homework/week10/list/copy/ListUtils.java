package com.aca.homework.week10.list.copy;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    private ListUtils() {
    }

    public static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }
}
