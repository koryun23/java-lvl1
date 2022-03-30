package com.aca.homework.week12.json;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JsonObjectProcessorTest {
    private JsonObjectProcessor jsonObjectProcessor;

    @BeforeEach
    public void setUp(){
        jsonObjectProcessor = new JsonObjectProcessor();
    }

    @Test
    public void testProcess(){
        Assertions.assertEquals("{username: frosty_chebyshev, name: Anton, age: 25}",
                jsonObjectProcessor.process(new User(
                        "frosty_chebyshev",
                        "Anton",
                        25
                ))
        );
    }
}