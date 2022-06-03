package com.aca.homework.week21.optional;

import java.io.Serializable;
import java.util.Optional;

public class OptionalMain {

    private final ArgumentConsumer argumentConsumer;

    public OptionalMain(ArgumentConsumer argumentConsumer) {
        this.argumentConsumer = argumentConsumer;
    }

    public void printFirstSymbol(Optional<String> string) {
        String str = string.map(s -> s.length() < 2 ? "" : s.substring(1))
                .map(s -> s.length() < 1 ? "" : s.charAt(0)).orElse("").toString();
        argumentConsumer.accept(str);
        System.out.println(str);
    }
}
