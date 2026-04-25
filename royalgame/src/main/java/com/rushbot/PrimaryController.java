package com.rushbot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PrimaryController {
   
    @FXML
    private Pane coinLayer;

    private CoinShower coins;

    @FXML
    public void initialize() {
        coins = new CoinShower(coinLayer);
        System.out.println("=== Spawning coin ===");
        try{
           coins.start();
        }
        catch(NullPointerException e){
           System.err.println("Image was not found!");
        }
    }
}
