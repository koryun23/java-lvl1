package com.aca.homework.week3.covidtest;

public class CovidTest {
    User user;
    boolean positive;

    public void print(){
        System.out.println("COVID TEST DATA: ");
        String output = this.positive ? "Covid test is positive" : "Covid test is negative";
        this.user.print();
        System.out.println(output);
    }
}
