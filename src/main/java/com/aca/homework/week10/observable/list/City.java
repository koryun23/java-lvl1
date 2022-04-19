package com.aca.homework.week10.observable.list;

public class City {
    private ArrayObservableList<Human> observableList;
    private City() {
    }
    public static City ofCity() {
        City city = new City();
        ListChangeListener<Human> humanTracker = new ListChangeListener<Human>() {
            @Override
            public void onAdded(Human item) {
                System.out.println("A new joiner is " + item.toString());
            }
        };
        ListChangeListener<Human> humanApplause = new ListChangeListener<Human>() {
            @Override
            public void onAdded(Human item) {
                System.out.println("applause");
                sleepForHalfSec();
                System.out.println("applause");
            }
        };
        city.observableList.addListener(humanTracker);
        city.observableList.addListener(humanApplause);
        return city;
    }
    private static void sleepForHalfSec() {
        long startMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - startMillis < 500) ;
    }

    public void addNewHuman(Human human){
        observableList.add(human);
    }

}