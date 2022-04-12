package com.aca.classwork.week9.effective.java.item30;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericMethods {
    public static <E> Set<E> union(Set<E> set1, Set<E> set2){
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(List.of(5, 6, 7, 8));
        System.out.println(union(set1, set2));
    }
}
