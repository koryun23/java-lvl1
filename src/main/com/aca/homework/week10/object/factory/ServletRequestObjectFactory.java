package com.aca.homework.week10.object.factory;

public class ServletRequestObjectFactory<T> implements ObjectFactory<T> {

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() {
        return (T) new ServletRequestImpl();
    }
}
