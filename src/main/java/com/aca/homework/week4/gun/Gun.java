package com.aca.homework.week4.gun;

public class Gun {
    private int cartridges = 0;
    public static void main(String[] args) {
        Gun gun = new Gun();
        gun.fire();
        for(int i = 0; i < 10; i++) {
            gun.load();
        }
        for(int i = 0; i < 10; i++) {
            gun.fire();
        }
    }
    public void fire(){
        if (this.cartridges == 0) {
            System.out.println("Could not fire the gun. It's empty.");
            return;
        }
        this.cartridges--;
        System.out.println("fire!");
    }

    public void load(){
        if(this.cartridges == 10){
            System.out.println("Could not load the gun. It's full already");
            return;
        }
        this.cartridges++;
        System.out.println("A cartridge is loaded");
    }
}
