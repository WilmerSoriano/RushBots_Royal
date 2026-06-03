package com.rushbot;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.AudioClip;

/*
    CORE IDEA:
    A function that => Method(On or Off, Music.mp3 or SoundEffect.mp3)
    LIST:
    * Basic Music [*got it]
    ==============Sound Effect audio========= 
    * Audio for clicking effect (when clicking back, or switching audio on or off ) [*got it]
    * Done Audio [*got it]
    * Winner audio [*got it]
    * Loser audio [*got it]
    * Selection Audio + with select audio confirming the click [*got it]
    Total: 6 Audio with 5 belonging to sound effect controlling it
*/

public class AudioManager{
   
    private static Boolean toggle;

    private static MediaPlayer bgMusic; // Made these static to make sure only 1 audio is played.
    private static AudioClip clickSE;
    private static MediaPlayer doneSE;
    private static MediaPlayer lostSE;
    private static MediaPlayer selectSE;
    private static MediaPlayer winnerSE;

    public AudioManager(){
       initBg();
       clickSE = new AudioClip(getClass().getResource("music/click.mp3").toExternalForm());
       //this.clickSE = init("click.mp3");
       this.doneSE = init("done.mp3");
       this.lostSE = init("lost.mp3");
       this.selectSE = init("select.mp3");
       this.winnerSE = init("winner.mp3");
       this.toggle = true;
    }
    
    public MediaPlayer init(String mediaName){
       Media media = new Media(getClass().getResource("music/"+mediaName).toExternalForm());
       return new MediaPlayer(media);
    }
    
    public void initBg(){
       if(bgMusic != null)
          return;
       
       Media media = new Media(getClass().getResource("music/MainMusic.mp3").toExternalForm());
       bgMusic = new MediaPlayer(media);
       bgMusic.setCycleCount(MediaPlayer.INDEFINITE);/* ONLY Main Music get to be replayed as needed until user decide to toggle off*/
       bgMusic.play();
    }
    
    public void controlMusic(ToggleButton button){
       if(!button.isSelected()){
          bgMusic.stop();
       }
       else{
          bgMusic.play();
       }
    }
    
    // the toggle is the flag that controls all the sound effect for either on or off
    public void controlSFX(ToggleButton button){
       this.toggle = button.isSelected();
    }
    
    public void clickSFX(){
       if(toggle){
          clickSE.play();
          //clickSE.setOnEndOfMedia(clickSE::dispose); // Resets the sound effect player after use.
       }
       else{
          clickSE.stop();
       }
    }
}
