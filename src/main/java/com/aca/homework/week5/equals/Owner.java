package com.aca.homework.week5.equals;

public class Owner {
    private String firstName;
    private String lastName;

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner) {
            Owner owner = (Owner) obj;
            return owner.firstName.equals(this.firstName) && owner.lastName.equals(this.lastName);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Owner %s: %s, %s: %s", "first name", firstName, "last name", lastName);
    }
}
