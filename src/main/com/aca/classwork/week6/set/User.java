package com.aca.classwork.week6.set;

public class User {
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static void main(String[] args) {
        Object user = new User("F", "L");
        Object child = new ChildUser("F", "L");

        System.out.println(user instanceof User);
        System.out.println(child instanceof User);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof User) {
            User anotherUser = (User) obj;
            return anotherUser.firstName.equals(this.firstName) && anotherUser.lastName.equals(this.lastName);
        }
        return false;
    }*/

    @Override
    public String toString(){
        return String.format("first name: %s; last name: %s", firstName, lastName);
    }
}
