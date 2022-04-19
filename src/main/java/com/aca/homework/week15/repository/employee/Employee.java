package com.aca.homework.week15.repository.employee;

public class Employee {
    private String id;
    private String firstName;
    private String secondName;
    private Long salary;

    public Employee(String id, String firstName, String secondName, Long salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString(){
        return String.format("EMPLOYEE[id=%s, first_name=%s, second_name=%s, salary=%d]",
                id, firstName, secondName, salary);
    }
}
