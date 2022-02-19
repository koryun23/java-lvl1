package com.aca.homework.week5.light.out;

public class Light {
    private String state;
    public Light(boolean boolState){
        state = boolState ? "on" : "off";
    }

    public String getState(){
        return state;
    }

    public void switchState(){
        state = state.equals("off") ? "on" : "off";
    }

    public boolean isOn(){
        return "on".equals(this.state);
    }
    @Override
    public String toString(){
        return isOn() ? "+" : "0";
    }
}
