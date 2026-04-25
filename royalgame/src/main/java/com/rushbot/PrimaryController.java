package com.rushbot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PrimaryController {
   
    @FXML
    private Pane coinLayer; // Loads the coin layer from fxml file

    private CoinShower coins;

    @FXML
    public void initialize() {
        coins = new CoinShower(coinLayer); // setting the coinlayer pane as background. NOT menuLayer
        System.out.println("=== Spawning coin ===");
        try{
           coins.start();
        }
        catch(NullPointerException e){
           System.err.println("Coin image not found!");
        }
    }
}
