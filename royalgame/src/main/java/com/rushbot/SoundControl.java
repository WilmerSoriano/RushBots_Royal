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
    private MediaPlayer audioPlayer;
    
    private String[] soundPlaylist = {"click.mp3", "done.mp3", "lost.mp3", "select.mp3", "winner.mp3"}; // Not including Main Music since it can be individually be toggled off

    public SoundControl(ToggleButton someButton)throws NullPointerException{
        if(someButton == null){
            throw new NullPointerException("No button found");
        }
        this.someButton = someButton;
    }

    public void setAudio(){
        String audioControl = someButton.getId();

        if(audioControl == "music_toggle"){
            Media media = new Media("MainMusic.mp3");
            audioPlayer = new MediaPlayer(media);
            controlAudio(someButton.isSelected());
        }
        else{
            System.out.println("Sound effect is turn off or on here");
        }
    }
    
    private void controlAudio(Boolean state){
        if(state == false){
            audioPlayer.stop();
        }
        else{
            audioPlayer.play();
        }
    }

    public void initialize(){
        /* Replay Main Music as needed until user decide to switch off*/
        Media media = new Media("MainMusic.mp3");
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setAutoPlay();
    }
}
