package com.aca.homework.week11.resolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloTranslatorResolver {
    private final Map<LanguageType, HelloTranslator> map = new HashMap<>();

    public HelloTranslatorResolver(List<HelloTranslator> helloTranslators) {
        fillHashMapWithTranslators(helloTranslators);
    }

    public void fillHashMapWithTranslators(List<HelloTranslator> helloTranslators) {
        for (HelloTranslator translator : helloTranslators) {
            map.put(translator.type(), translator);
        }
    }

    public HelloTranslator resolve(LanguageType languageType) {
        return map.get(languageType);
    }
}
