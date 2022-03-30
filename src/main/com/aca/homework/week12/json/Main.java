package com.aca.homework.week12.json;

public class Main {
    public static void main(String[] args) {
        JsonObjectProcessor jsonObjectProcessor = new JsonObjectProcessor();
        User user = new User("frosty_chebyshev", "Anton", 25);
        System.out.println(jsonObjectProcessor.process(user));
    }

}
