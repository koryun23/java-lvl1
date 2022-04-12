package com.aca.classwork.week9.effective.java.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> { // type-safe generic class
    private final List<T> choiceList;

    public Chooser(Collection<T> choices){
        choiceList = new ArrayList<>(choices);
    }

    // better to use list instead of array

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
