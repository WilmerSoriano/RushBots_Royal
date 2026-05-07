package com.rushbot;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

/*
    CORE IDEA:
    A function that => Method(On or Off, Music.mp3 or SoundEffect.mp3)
    LIST:
    * Basic Music 
    ==============Sound Effect audio========= 
    * Audio for clicking effect (when clicking back, or switching audio on or off )
    * Winner audio
    * Loser audio
    * Selection Audio + with select audio confirming the click
    Total: 6 Audio with 4 belonging to sound effect controlling it
*/

public class SoundControl {
    @FXML
    private ToggleButton button;

    public SoundControl(ToggleButton button)throws NullPointerException{
        if(button == null){
            throw new NullPointerException("Audio not found!");
        }
        this.button = button;
    }

    public void action(){
        if((button.isSelected()) == false){
            System.out.println("Turn off");
        }else{
            System.out.println("Turn on");
        }

    } 
}
