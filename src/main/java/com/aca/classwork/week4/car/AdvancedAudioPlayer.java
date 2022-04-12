package com.aca.classwork.week4.car;

public class AdvancedAudioPlayer extends AudioPlayer {

    public AdvancedAudioPlayer(){
        System.out.println("AdvancedAudioPlayer");
    }


    public void pause() {
        System.out.println("Pause");
    }

    @Override
    public void play(){

    }
    public static void main(String[] args) {
        AdvancedAudioPlayer advancedAudioPlayer = new AdvancedAudioPlayer();
        advancedAudioPlayer.play();
        System.out.println(advancedAudioPlayer.isPlaying());
        advancedAudioPlayer.setPlaying(false);
        System.out.println(advancedAudioPlayer.isPlaying());



    }


}
