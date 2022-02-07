package com.aca.classwork.week5.developer;

public class Developer {
    private String name;

    public Developer(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public long getSalary(){
        return 60_000;
    }

    public long getBudget(){
        return 300;
    }

    public static void main(String[] args){
        Developer developer = new Developer("Kate");
        System.out.println(developer.toString());
    }

    @Override
    public String toString(){
        return "name " + getName() + " salary " + getSalary();
    }

    @Override
    public boolean equals(Object obj){
        Developer o1 = (Developer) obj;
        return this.name.equals(o1.name);
    }
}
