package com.aca.classwork.week4.car;

public class AudioPlayer {
    private boolean isPlaying;

    public AudioPlayer(){
        System.out.println("Audio Player");
    }

    public void play() {
        System.out.println("Playing...");
        this.isPlaying = true;
    }


    public void stop() {
        System.out.println("Stopped playing");
        this.isPlaying = false;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
    public void setPlaying(boolean b) {
        this.isPlaying = b;
    }

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();

    }
}
