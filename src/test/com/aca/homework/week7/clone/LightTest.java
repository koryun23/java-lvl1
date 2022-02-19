package com.aca.homework.week7.clone;

class LightTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        Light lightOn = Light.lightOf(true);
        Light lightOff = Light.lightOf(false);

        Light lightOnClone = (Light) lightOn.clone();
        Light lightOffClone = (Light) lightOff.clone();

        System.out.println(lightOn.getState());
        System.out.println(lightOnClone.getState());
        System.out.println(lightOff.getState());
        System.out.println(lightOffClone.getState());
    }
}