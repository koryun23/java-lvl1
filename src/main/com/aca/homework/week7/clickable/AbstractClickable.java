package com.aca.homework.week7.clickable;

public abstract class AbstractClickable implements Clickable{
    Action action;
    public AbstractClickable(Action action){
        this.action = action;
    }

    @Override
    public void click(){
        action.doAction(this);
    }
}
