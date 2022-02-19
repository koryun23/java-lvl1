package com.aca.homework.week7.clone;

public class Light implements Cloneable{
    private State state;
    private static Light[] lights = new Light[2];
    private Light(boolean state){
        this.state = state ? State.ON : State.OFF;
    }

    public static Light lightOf(boolean state){
        int index = getIndexByState(state);
        if(objectExists(state)){
            return lights[index];
        }
        storeNewLightObject(state);
        return lights[index];
    }

    public static boolean objectExists(boolean state){
        return lights[getIndexByState(state)] != null;
    }

    public static int getIndexByState(boolean state){
        return state ? 1 : 0;
    }

    public static void storeNewLightObject(boolean state){
        lights[getIndexByState(state)] = new Light(state);
    }

    public String getState(){
        return state.name();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
