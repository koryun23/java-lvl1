package com.aca.classwork.week7.string.performance;

public class Main {
    public static void main(String[] args) {
        StringMaker badMaker = StringMaker.ofBad();
        System.out.println(badMaker.make(1, 100_000).getExecutionTime());
        StringMaker goodMaker = StringMaker.ofGood();
        System.out.println(goodMaker.make(1, 100_000).getExecutionTime());


        StringMaker[] array = new StringMaker[5];
        array[0] = StringMaker.ofBad();
        array[1] = StringMaker.ofBad();
        array[2] = StringMaker.ofGood();
        array[3] = StringMaker.ofGood();
        array[4] = StringMaker.ofGood();

        for (StringMaker stringMaker : array) {
            if (stringMaker instanceof LowPerformance) {
                System.out.println("The starting maker has low performance");
            }
        }
    }
}
