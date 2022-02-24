package com.aca.classwork.week7.annotations;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

class StringMakerTest {
    public static void main(String[] args) {
        StringMaker bad = StringMaker.ofBad();
        StringMaker good = StringMaker.ofGood();
        StringMaker[] stringMakers = {bad, good};
        for(StringMaker stringMaker : stringMakers) {
            Annotation[] declaredAnnotations = stringMaker.getClass().getDeclaredAnnotations();
            if(declaredAnnotations.length > 0 && declaredAnnotations[0].annotationType() == HighPerformance.class){
                System.out.println(stringMaker.make(1, 100_000).getExecutionTime());
            }
        }

    }
}