package com.aca.homework.week6.list;

public class ArrayList implements List {
    private String[] values = new String[10];
    private int length = 0;

    public void add(String value) {
        if (isArrayListFull()) {
            assignToDoubleSizedArray();
        }
        values[length++] = value;
    }

    public String get(int index) {
        if (accessedElementExists(index)) {
            return values[index];
        }
        throw new RuntimeException();
    }

    public boolean isArrayListFull() {
        return length == values.length;
    }

    public boolean accessedElementExists(int index) {
        return index >= 0 && index < values.length && values[index] != null;
    }

    public void assignToDoubleSizedArray() {
        values = getDoubleSizedArray();
    }

    public String[] getDoubleSizedArray() {
        String[] newValuesArray = new String[values.length * 2];
        copyContentToDestinationArray(newValuesArray);
        return newValuesArray;
    }

    public void copyContentToDestinationArray(String[] destinationArray) {
        for (int i = 0; i < values.length; i++) {
            destinationArray[i] = values[i];
        }
    }

}
