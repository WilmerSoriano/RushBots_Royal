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
            System.out.println("Turn off");
        }else{
            System.out.println("Turn on");
        }

    } 
}
