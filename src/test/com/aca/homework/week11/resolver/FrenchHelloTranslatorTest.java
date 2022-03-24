package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrenchHelloTranslatorTest {
    private HelloTranslator translator;

    @BeforeEach
    public void setUp() {
        translator = new FrenchHelloTranslator();
    }

    @Test
    public void testResolveWithHelloMethodWhenLanguageIsFrench() {
        Assertions.assertEquals("Salut", translator.hello());
    }

    @Test
    public void testType() {
        Assertions.assertEquals(LanguageType.FRENCH, translator.type());
    }
}