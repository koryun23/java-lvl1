package com.aca.homework.week11.resolver;

public class FrenchHelloTranslator implements HelloTranslator {
    @Override
    public String hello() {
        return "Salut";
    }

    @Override
    public LanguageType type() {
        return LanguageType.FRENCH;
    }
}
