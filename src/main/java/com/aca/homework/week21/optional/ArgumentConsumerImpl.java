package com.aca.homework.week21.optional;

import java.util.LinkedList;
import java.util.List;

public class ArgumentConsumerImpl implements ArgumentConsumer {

    private final List<String> arguments;

    public ArgumentConsumerImpl() {
        arguments = new LinkedList<>();
    }

    @Override
    public void accept(String s) {
        arguments.add(s);
    }

    @Override
    public List<String> getArguments() {
        return arguments;
    }

    @Override
    public String getLastArgument() {
        return arguments.get(arguments.size() - 1);
    }
}
