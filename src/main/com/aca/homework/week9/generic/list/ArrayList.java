package com.aca.homework.week9.generic.list;

public class ArrayList<E> implements List<E> {
    private final Object[] elements = new Object[1000];
    private int numberOfElements = 0;

    @Override
    public void add(E element) {
        elements[numberOfElements++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= numberOfElements) throw new ArrayListIndexOutOfBoundsException(index, numberOfElements);
        return (E) elements[index];
    }

    @Override
    public int size() {
        return numberOfElements;
    }
}
