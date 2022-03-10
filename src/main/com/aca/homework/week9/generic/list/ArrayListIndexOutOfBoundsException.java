package com.aca.homework.week9.generic.list;

public class ArrayListIndexOutOfBoundsException extends RuntimeException{
    public ArrayListIndexOutOfBoundsException(int index, int size){
        super(String.format("index %d is not valid for an array list with size %d", index, size));
    }
}
