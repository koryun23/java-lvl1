package com.aca.homework.week10.observable.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayObservableListTest {

    @Test
    public void testAddWhenThereIsNoAddedListeners() {
        ObservableList<String> arrayObservableList = new ArrayObservableList<>();
        arrayObservableList.add("item");
        Assertions.assertEquals("item", arrayObservableList.get(0));
    }

    @Test
    public void testAddWhenThereIsOneAddedListener() {
        ObservableList<Integer> arrayObservableList = new ArrayObservableList<>();
        final Integer[] argument = {0};
        arrayObservableList.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onAdded(Integer item) {
                argument[0] = item;
            }
        });
        arrayObservableList.add(98);
        Assertions.assertEquals(98, argument[0]);
    }

    @Test
    public void testAddWhenThereAreTwoAddedListener() {
        ObservableList<Integer> arrayObservableList = new ArrayObservableList<>();
        final Integer[] argumentForFirstListener = {0};
        final Integer[] argumentForSecondListener = {0};
        arrayObservableList.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onAdded(Integer item) {
                argumentForFirstListener[0] = 98;
            }
        });
        arrayObservableList.addListener(new ListChangeListener<Integer>() {
            @Override
            public void onAdded(Integer item) {
                argumentForSecondListener[0] = item;
            }
        });
        arrayObservableList.add(98);
        Assertions.assertEquals(98, argumentForFirstListener[0]);
        Assertions.assertEquals(98, argumentForSecondListener[0]);
    }
}