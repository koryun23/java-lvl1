package com.aca.homework.week4.developer;

public class DeveloperTest {
    public static void main(String[] args) {
        Developer developer = new Developer("Gerard");
        developer.print();

        JuniorDeveloper juniorDeveloper = new JuniorDeveloper("Maricar");
        juniorDeveloper.print();

        SeniorDeveloper seniorDeveloper = new SeniorDeveloper("Emily");
        seniorDeveloper.print();
    }
}
