package com.aca.homework.week11.car.wash;

public class Main {
    public static void main(String[] args) {
        CarWash jilly = new CarWash("JILLY'S");
        System.out.println(jilly.wash("777QA77"));
        System.out.println(jilly.wash("777QA77"));
        System.out.println(jilly.wash("777QA77"));
        System.out.println(jilly.wash("777QA77"));
        System.out.println(jilly.wash("777QA77"));
        System.out.println(jilly.load().toString());

        CarWash sonax = new CarWash("SONAX");
        System.out.println(sonax.wash("111AA11"));
        System.out.println(sonax.wash("48BX132"));
        System.out.println(sonax.load().toString());

    }
}
