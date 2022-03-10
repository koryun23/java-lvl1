package com.aca.homework.week9.generic.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ArrayListTest {
    @Test
    public void testSizeForStringArrayList() {
        List<String> arrayListOfStrings = new ArrayList<>();
        Assertions.assertEquals(0, arrayListOfStrings.size());
    }

    @Test
    public void testAddForStringArrayList() {
        List<String> arrayListOfStrings = new ArrayList<>();
        arrayListOfStrings.add("test1");
        Assertions.assertEquals(1, arrayListOfStrings.size());
    }

    @Test
    public void testGetForStringArrayList() {
        List<String> arrayListOfStrings = new ArrayList<>();
        arrayListOfStrings.add("test1");
        arrayListOfStrings.add("test2");
        Assertions.assertEquals("test2", arrayListOfStrings.get(1));
    }

    @Test
    public void testGetWithInvalidIndexForStringArrayList() {
        List<String> arrayListOfStrings = new ArrayList<>();
        Assertions.assertThrows(ArrayListIndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                arrayListOfStrings.get(0);
            }
        });
    }

    @Test
    public void testSizeForIntegerArrayList() {
        List<Integer> arrayListOfIntegers = new ArrayList<>();
        Assertions.assertEquals(0, arrayListOfIntegers.size());
    }

    @Test
    public void testAddForIntegerArrayList() {
        List<Integer> arrayListOfIntegers = new ArrayList<>();
        arrayListOfIntegers.add(1);
        Assertions.assertEquals(1, arrayListOfIntegers.size());
    }

    @Test
    public void testGetForIntegerArrayList() {
        List<Integer> arrayListOfStrings = new ArrayList<>();
        arrayListOfStrings.add(1);
        arrayListOfStrings.add(2);
        Assertions.assertEquals(2, arrayListOfStrings.get(1));
    }

    @Test
    public void testGetWithInvalidIndexForIntegerArrayList() {
        List<Integer> arrayListOfStrings = new ArrayList<>();
        Assertions.assertThrows(ArrayListIndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                arrayListOfStrings.get(0);
            }
        });
    }
}