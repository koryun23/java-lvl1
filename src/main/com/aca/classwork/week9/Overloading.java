package com.aca.classwork.week9;

public class Overloading {
    public void invoke(Object o){
        System.out.println("o");
    }

    public void invoke(User u){
        System.out.println("u");
    }

    public void invoke(SubUser su){
        System.out.println("su");
    }

    public static void main(String[] args) {

        Overloading overloading = new Overloading();
        Object o = new User();
        User u = new SubUser();
        SubUser su = new SubUser();

        overloading.invoke(o);
        overloading.invoke(u);
        overloading.invoke(su);

    }

}
