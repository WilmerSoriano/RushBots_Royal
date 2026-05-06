package com.rushbot;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;

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
            /*
                A function that: Method(On or Off, Music.mp3 or SoundEffect.mp3)
            */
            System.out.println("Turn off");
        }else{
            System.out.println("Turn on");
        }

    } 
}
