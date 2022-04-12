package com.aca.classwork.week11.printer;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");

        list.forEach(new java.util.function.Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
