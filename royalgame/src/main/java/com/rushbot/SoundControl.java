package com.rushbot;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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

public class SoundControl {
    @FXML
    private ToggleButton someButton;

    private MediaPlayer mediaPlayer;
    
    private String mp3Sound;
    
    private Boolean state = true;

    public SoundControl(String mp3Sound){
        this.mp3Sound = mp3Sound;
    }
    
    public void controlAudio(ToggleButton someButton){
       state = someButton.isSelected();
    }
    
    public void checkAudio(){
        if(state == false){
            mediaPlayer.stop();
        }
        else{
            mediaPlayer.play();
        }
    }

    public void initAudio(){
        Media media = new Media(getClass().getResource("music/"+mp3Sound).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        
        /* ONLY Main Music get to be replayed as needed until user decide to toggle off*/
        if(mp3Sound.equals("MainMusic.mp3")){
           mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }
    }
}
