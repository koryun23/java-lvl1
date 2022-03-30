package com.aca.homework.week12.temperature;

import java.util.List;

public interface DataGenerator<T> {
    List<T> generate();
}
