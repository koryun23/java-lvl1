package com.aca.homework.week5.pistol;

public class MakarovPistol extends Pistol{
    public MakarovPistol(){
        super("MakarovPistol");
    }

    @Override
    public void shoot(){
        System.out.println("makarov fire!!");
    }
}
