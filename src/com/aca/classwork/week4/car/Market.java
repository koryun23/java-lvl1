package com.aca.classwork.week4.car;

public class Market {
    private static int carsSold;
    public static Car carOption1() {
        Market.carsSold++;
        return new Car(new AudioPlayer());
    }

    public static Car carOption2() {
        Market.carsSold++;
        return new Car();
    }

    public static void main(String[] args) {
        Car carWithAudioPlayer = Market.carOption1();
        Car carWithoutAudioPlayer = Market.carOption2();

        carWithAudioPlayer.openDoors();
        carWithAudioPlayer.closeDoors();

        carWithoutAudioPlayer.openDoors();
        carWithoutAudioPlayer.closeDoors();

        System.out.println("Cars sold: " + Market.carsSold);

    }
}
