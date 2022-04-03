package com.aca.homework.week13.consumer;

import java.util.List;
import java.util.function.Consumer;

public class TextPrinter {

    Consumer<String> consumer;
    public TextPrinter(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public void printAll(List<String> list){
        list.forEach(consumer);
    }
}
