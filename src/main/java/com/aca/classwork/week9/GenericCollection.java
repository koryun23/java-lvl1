package com.aca.classwork.week9;

public class GenericCollection<E> {
    private static final int ARRAY_SIZE = 100;

    private Object[] objects = new Object[ARRAY_SIZE];

    public E get(int index){
        return (E) objects[index];
    }

    public static <E> E identity(E input){ // generic method
        return input;
    }
    public static void main(String[] args) {
        GenericCollection<Integer> genericCollection1 = new GenericCollection();
        genericCollection1.objects[0] = 45L;
        genericCollection1.objects[1] = "45string";
        GenericCollection genericCollection2 = new GenericCollection();
    }
}
