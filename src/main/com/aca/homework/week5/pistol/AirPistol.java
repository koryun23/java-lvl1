package com.aca.homework.week5.pistol;

public class AirPistol extends Pistol{
    public AirPistol(){
        super("AirPistol");
    }

    @Override
    public void shoot(){
        System.out.println("air pistol fire!");
    }
}
