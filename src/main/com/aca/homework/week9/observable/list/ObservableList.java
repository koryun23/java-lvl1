package com.aca.homework.week9.observable.list;

public interface ObservableList<T> {
    void add(T item);

    T get(int index);

    int size();

    void addListener(ListChangeListener<T> listener);
}
