package com.aca.homework.week11.resolver;

public class EnglishHelloTranslator implements HelloTranslator {
    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public LanguageType type() {
        return LanguageType.ENGLISH;
    }
}
