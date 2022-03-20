package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RussianHelloTranslatorTest {
    private HelloTranslator translator;

    @BeforeEach
    public void setUp() {
        translator = new RussianHelloTranslator();
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsRussian() {
        Assertions.assertEquals("Привет", translator.hello());
    }
}