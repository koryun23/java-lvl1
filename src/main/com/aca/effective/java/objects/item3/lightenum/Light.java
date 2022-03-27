package com.aca.effective.java.objects.item3.lightenum;

public enum Light { // singleton using enum
    ON(true),
    OFF(false);

    private boolean state;

    Light(boolean state){
        this.state = state;
    }

    public static Light on(){
        return ON;
    }

    public static Light off(){
        return OFF;
    }
}
