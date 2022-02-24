package com.aca.homework.week7.list.empty;

public class FixedSizeList implements List{
    private Object[] elements = new Object[10];
    private int numOfElements;

    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public void add(Object o) {
        if(listIsFull()) throw new RuntimeException("The list is full");
        elements[numOfElements++] = o;
    }

    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }

    @Override
    public Object get(int index) {
        if(indexOutOfRange(index)) throw new RuntimeException("List index out of range");
        return elements[index];
    }

    public boolean indexOutOfRange(int index){
        return index < 0 || index >= numOfElements;
    }

    public boolean listIsFull(){
        return numOfElements == elements.length;
    }
}
