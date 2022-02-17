package com.aca.classwork.week5.developer;

public class JuniorDeveloper extends Developer{
    private long salary;
    public JuniorDeveloper(){
        super("John");
        System.out.println();
    }

    public JuniorDeveloper(String name, long salary){
        super(name);
        this.salary = salary;
    }

    public long getSalary(){
        return salary;
    }
    public static void main(String[] args) {
        JuniorDeveloper juniorDeveloper = new JuniorDeveloper("Yan", 45_000);
        juniorDeveloper.toString();
    }
}
