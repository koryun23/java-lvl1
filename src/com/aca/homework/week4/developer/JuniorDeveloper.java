package com.aca.homework.week4.developer;

public class JuniorDeveloper extends Developer {
    public JuniorDeveloper(String name){
        super(name);
    }
    public int getLearningBudget() {
        return super.getLearningBudget() * 2;
    }

    public int getSalary() {
        return 300_000;
    }
}
