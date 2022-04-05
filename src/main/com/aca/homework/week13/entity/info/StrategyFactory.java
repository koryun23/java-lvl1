package com.aca.homework.week13.entity.info;

import java.lang.annotation.Annotation;

public class StrategyFactory {

    public PrintInfoStrategy getStrategy(Object o) {
        return isObjectAnnotatedAsEntity(o) ? new PrintEntityInfo(o) : new PrintNonEntityInfo();
    }

    private boolean isObjectAnnotatedAsEntity(Object o) {
        Annotation[] annotations = o.getClass().getDeclaredAnnotations();
        for(Annotation ann : annotations) {
            if(ann.annotationType() == Entity.class) {
                return true;
            }
        }
        return false;
    }
}
