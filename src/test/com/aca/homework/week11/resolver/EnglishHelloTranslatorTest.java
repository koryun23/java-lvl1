package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnglishHelloTranslatorTest {
    private HelloTranslator translator;

    @BeforeEach
    public void setUp() {
        translator = new EnglishHelloTranslator();
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsEnglish() {
        Assertions.assertEquals("Hello", translator.hello());
    }
}