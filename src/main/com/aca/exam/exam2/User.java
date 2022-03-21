package com.aca.exam.exam2;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof User) {
            User other = (User) obj;
            return other.getFirstName().equals(firstName) && other.getLastName().equals(lastName) && other.getId().equals(id);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(
                "user id: %s; user first name: %s; user last name: %s",
                id, firstName, lastName
        );
    }
}
