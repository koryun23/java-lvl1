package com.aca.exam.exam3;

import org.hibernate.HibernateException;
import org.hibernate.action.spi.Executable;

import java.util.concurrent.Callable;

public class NumberCallable implements Callable<String> {

    private int index;
    private String[] array;

    public NumberCallable(String[] array, int index) {
        this.array = array;
        this.index = index;
    }

    @Override
    public String call() throws Exception {
        return array[index];
    }
}
