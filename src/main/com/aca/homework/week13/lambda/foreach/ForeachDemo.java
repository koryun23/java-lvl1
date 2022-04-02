package com.aca.homework.week13.lambda.foreach;

import java.util.List;

public class ForeachDemo {
    public static void main(String[] args) {
        List<String> list = List.of("1", "10", "text", "25");

        list.forEach(s -> {
            System.out.println("item value is " + s);
            System.out.println("item length is " + s.length());
        });
    }
}
