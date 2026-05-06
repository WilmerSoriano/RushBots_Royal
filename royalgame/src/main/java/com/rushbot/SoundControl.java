package com.rushbot;

import javafx.scene.control.ToggleButton;

public class SoundControl {
    @FXML
    private ToggleButton button;

    public SoundControl(ToggleButton button)throws NullPointerException{
        if(button == null){
            throw new NullPointerException("Audio not found!");
        }
        this.button = button;

        action(button);
    }

    public void action(ToggleButton tb){
        if((button.isSelected()) == False){
            System.out.println("Turn off");
        }else{
            System.our.println("Turn on");
        }

    } 
}
