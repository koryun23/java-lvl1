package com.aca.homework.week5.pistol;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Pistol[] pistols = getMultiplePistols();
        shootAllPistols(pistols);
    }

    public static Pistol[] getMultiplePistols(){
        Pistol[] pistols = new Pistol[4];
        int pistolIndex = 0;
        for(int i = 0; i < 4; i++){
            Pistol newPistol = getPistol();
            if (newPistol!=null){
                pistols[pistolIndex++] = newPistol;
            }
        }
        return pistols;
    }
    public static void shootAllPistols(Pistol[] pistols){
        for(Pistol pistol : pistols){
            if(pistol != null) pistol.shoot();
            else break;
        }
    }
    public static Pistol getPistol(){
        Scanner scanner = new Scanner(System.in);
        String pistolName = scanner.nextLine();
        if(!validatePistolName(pistolName)) return null;
        if("air".equals(pistolName)){
            return new AirPistol();
        }
        if("makarov".equals(pistolName)){
            return new MakarovPistol();
        }
        return new NagantPistol();
    }

    public static boolean validatePistolName(String name){
        return "air".equals(name) || "makarov".equals(name) || "nagant".equals(name);
    }
}
