package com.aca.classwork.week6.set;


class ArraySetTest {
    public static void main(String[] args) {
        ArraySet set = new ArraySet();
        set.add(new User("firstName1", "lastName1"));
        set.add(new User("firstName2", "lastName2"));
        set.add(new User("firstName3", "lastName3"));
        set.add(new User("firstName4", "lastName4"));
        set.add(new User("firstName5", "lastName5"));

        assert set.size() == 5 : "FAIL";
    }
}