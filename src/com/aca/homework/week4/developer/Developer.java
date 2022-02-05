package com.aca.homework.week4.developer;

public class Developer {
    private String name;

    public Developer(String name){
        this.name = name;
    }
    public int getSalary() {
        return 60_000;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLearningBudget() {
        return 300;
    }

    public void print(){
        System.out.printf("name: %s, salary: %s, learning budget: %s\n", this.name, this.getSalary(), this.getLearningBudget());
    }
}
