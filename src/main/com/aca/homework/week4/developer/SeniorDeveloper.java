package com.aca.homework.week4.developer;

public class SeniorDeveloper extends Developer {
    public SeniorDeveloper(String name){
        super(name);
    }
    public int getLearningBudget() {
        return super.getLearningBudget() * 8;
    }

    public int getSalary() {
        return 3_000_000;
    }
}
