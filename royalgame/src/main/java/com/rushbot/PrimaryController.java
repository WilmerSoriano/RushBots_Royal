package com.rushbot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

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
    
    public void startGame(ActionEvent e){
       System.out.println("Starting Game!");
    }
    public void loadGame(ActionEvent e){
       System.out.println("Loading Game!");
    }
    public void showCredit(ActionEvent e){
       System.out.println("Showing credits");
    }
    public void showSettings(ActionEvent e){
       System.out.println("Showing settings");
    }
}
