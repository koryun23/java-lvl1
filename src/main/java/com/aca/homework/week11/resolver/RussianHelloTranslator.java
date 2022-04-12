package com.aca.homework.week11.resolver;

public class RussianHelloTranslator implements HelloTranslator {
    @Override
    public String hello() {
        return "Привет";
    }

    @Override
    public LanguageType type() {
        return LanguageType.RUSSIAN;
    }
}
