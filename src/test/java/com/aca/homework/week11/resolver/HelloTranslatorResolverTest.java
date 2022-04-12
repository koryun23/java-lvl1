package com.aca.homework.week11.resolver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HelloTranslatorResolverTest {
    private HelloTranslatorResolver translator;

    @BeforeEach
    public void setUp() {
        translator = new HelloTranslatorResolver(List.of(new EnglishHelloTranslator(), new FrenchHelloTranslator(), new RussianHelloTranslator()));
    }

    @Test
    public void testResolve() {
        Assertions.assertEquals("Hello", translator.resolve(LanguageType.ENGLISH).hello());
        Assertions.assertEquals("Salut", translator.resolve(LanguageType.FRENCH).hello());
        Assertions.assertEquals("Привет", translator.resolve(LanguageType.RUSSIAN).hello());
    }
}