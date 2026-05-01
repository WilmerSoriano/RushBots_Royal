package com.rushbot;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.net.URI;

public class PrimaryController {
   
    @FXML
    private Pane coinLayer; // Loads the coin layer from fxml file

    private CoinShower coins;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @FXML
    public void initialize() {
        try{
           coins = new CoinShower(coinLayer); // setting the coinlayer pane as background. NOT menuLayer
           coins.start();
        }
        catch(NullPointerException e){
           System.out.println("Coin image not found!");
        }
    }
    
    // The ActionEvent is communicated via fxml file with onAction call
    public void startGame(ActionEvent e){
       System.out.println("Starting Game!");
    }
    public void loadGame(ActionEvent e){
       System.out.println("Loading Game!");
    }
    public void showCredit(ActionEvent e)throws IOException{
       System.out.println("Showing credits");
       //coins.stop not needed since catch handles error with no event (e.g Start and Stop button doesn't exist if class is Null)
       App.setRoot("CreditScene");
    }
    public void showSettings(ActionEvent e)throws IOException{
       System.out.println("Showing settings");
       App.setRoot("SettingScene");
    }
    
    public void openYoutube(ActionEvent e)throws IOException{
       System.out.println("Opening YouTube");
          
       Desktop desktop = Desktop.getDesktop();
       
       if (desktop.isSupported(Desktop.Action.BROWSE)){
          desktop.browse(java.net.URI.create("https://www.youtube.com/@BroCodez"));
       }
       else{
          System.out.println("WARNING: Your Environment does not support GUI to Link");
       }
    }

    public void openGithub(ActionEvent e)throws IOException{
       System.out.println("opening github");
            
       Desktop desktop = Desktop.getDesktop();
       
       if (desktop.isSupported(Desktop.Action.BROWSE)){
          desktop.browse(java.net.URI.create("https://github.com/WilmerSoriano/RushBots_Royal.git"));
       }
       else{
          System.out.println("WARNING: Your Environment does not support GUI to Link");
       }
    }
    
    public void onReturn(ActionEvent e) throws IOException{
       System.out.println("Main Menu");
       App.setRoot("MenuScene");
    }
}
