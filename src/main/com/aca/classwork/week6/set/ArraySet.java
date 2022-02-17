package com.aca.classwork.week6.set;

public class ArraySet extends AbstractSet implements Set{

    private User[] array = new User[10];
    private int pointer;


    @Override
    public final void add(User user) {
        if (contains(user)){
            System.out.println("The user " + user.toString() + " already exists.");
            return;
        }
        array[pointer++] = user;
    }

    @Override
    public boolean contains(User user) {
        for(User currentUser : array){
            if (currentUser != null && currentUser.equals(user)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return pointer;
    }
}
