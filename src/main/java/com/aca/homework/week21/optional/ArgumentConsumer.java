package com.aca.homework.week21.optional;

import java.util.List;
import java.util.function.Consumer;

public interface ArgumentConsumer extends Consumer<String> {

    @Override
    void accept(String s);

    List<String> getArguments();

    String getLastArgument();
}
