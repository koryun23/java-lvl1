package com.aca.effective.java.item3.lightsingleton;

public class LightDemo {
    public static void main(String[] args) {
        Light lightOn = Light.on();
        Light anotherLightOn = Light.on();
        System.out.println(lightOn == anotherLightOn);

        Light lightOff = Light.off();
        Light anotherLightOff = Light.off();
        System.out.println(lightOff == anotherLightOff);
    }
}
