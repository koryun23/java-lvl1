package com.aca.homework.week5.pistol;

public abstract class Pistol {
    String name;
    public Pistol(String name){
        this.name = name;
    }
    public abstract void shoot();
    // I declared the method shoot as abstract because it doesn't make sense for it to have default implementation,
    // as all the subclasses implement it in their own way.
    // since the method is abstract the class must be abstract too
    // I think it's safe to do so because we do not need to instantiate the class anywhere in the program

}
