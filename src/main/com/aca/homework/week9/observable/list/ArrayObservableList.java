package com.aca.homework.week9.observable.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayObservableList<T> implements ObservableList<T> {
    private final Object[] observableList = new Object[100_000];
    private final List<ListChangeListener<T>> listChangeListeners = new ArrayList<>();
    private int numberOfObservables = 0;

    @Override
    public void add(T item) {
        observableList[numberOfObservables++] = item;
        for (ListChangeListener<T> listener : listChangeListeners) {
            listener.onAdded(item);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) observableList[index];
    }

    @Override
    public int size() {
        return numberOfObservables;
    }

    @Override
    public void addListener(ListChangeListener<T> listener) {
        listChangeListeners.add(listener);
    }
}
