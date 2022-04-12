package com.aca.homework.week10.object.factory;

public class ServletRequestObjectFactory implements ObjectFactory<ServletRequest> {

    @Override
    public ServletRequest getObject() {
        return new ServletRequestImpl();
    }
}
