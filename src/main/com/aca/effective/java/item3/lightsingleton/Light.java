package com.aca.effective.java.item3.lightsingleton;

public class Light {
    private static final Light lightOff = new Light(false);
    private static final Light lightOn = new Light(true);

    private boolean state;

    private Light(boolean state){
        this.state = state;
    }

    public static Light off(){
        return lightOff;
    }

    public static Light on(){
        return lightOn;
    }
}
