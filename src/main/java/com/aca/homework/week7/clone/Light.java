package com.aca.homework.week7.clone;

public class Light implements Cloneable{
    private State state;
    private Light(boolean state){
        this.state = state ? State.ON : State.OFF;
    }

    public static Light onLight(){
        return new Light(true);
    }

    public static Light offLight(){
        return new Light(false);
    }
    public String getState(){
        return state.name();
    }

    @Override
    protected Light clone() throws CloneNotSupportedException {
        return (Light) super.clone();
    }
}
