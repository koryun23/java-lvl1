package com.aca.classwork.week4.car;

public class Car {
    private AudioPlayer audioPlayer;

    public static void waitForSeconds(int seconds) {
        long startTime = System.currentTimeMillis();
        while ((System.currentTimeMillis() - startTime) / 1000 < seconds) {

        }
    }

    public Car(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public Car() {
    }

    public void openDoors() {
        System.out.println("Doors opened.");
        if (this.audioPlayer != null && !this.audioPlayer.isPlaying()) {
            this.audioPlayer.play();
            Car.waitForSeconds(10);
            this.audioPlayer.stop();
        }

    }

    public void closeDoors() {
        System.out.println("Doors closed.");
        if (this.audioPlayer != null && this.audioPlayer.isPlaying()) this.audioPlayer.stop();
    }
}
