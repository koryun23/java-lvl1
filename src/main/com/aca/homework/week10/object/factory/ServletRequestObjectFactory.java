package com.aca.homework.week10.object.factory;

public class ServletRequestObjectFactory<ServletRequest> implements ObjectFactory<ServletRequest> {

    @Override
    @SuppressWarnings("unchecked")
    public ServletRequest getObject() {
        return (ServletRequest) new ServletRequestImpl();
    }
}
