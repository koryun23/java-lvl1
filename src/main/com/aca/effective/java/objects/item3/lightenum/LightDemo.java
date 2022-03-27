package com.aca.effective.java.objects.item3.lightenum;

public class LightDemo {
    public static void main(String[] args) {
        Light lightOn = Light.ON;
        Light anotherLightOn = Light.ON;
        System.out.println(lightOn == anotherLightOn);

        Light lightOff = Light.OFF;
        Light anotherLightOff = Light.OFF;
        System.out.println(lightOff == anotherLightOff);
    }
}
